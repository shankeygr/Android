package com.gotution.app.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.gotution.app.data.DBWrapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermissionUtils {

    private static final String LOG_TAG = PermissionUtils.class.getSimpleName();

    public static final int REQUEST_CAMERA = 0;
    public static final int REQUEST_SMS = 1;
    public static final int REQUEST_STORAGE = 2;
    public static final int REQUEST_LOCATION = 3;
    public static final int REQUEST_CAM_STORAGE = 4;
    public static final int REQUEST_EMAIL = 5;

    public static final int STORAGE_AVAIL_CAM_NEVER_ASK = 10;
    public static final int STORAGE_AVAIL_CAM_NOT_AVAIL = 11;
    public static final int CAM_AVAIL_STORAGE_NEVER_ASK = 20;
    public static final int CAM_AVAIL_STORAGE_NOT_AVAIL = 21;
    public static final int CAM_STORAGE_NOT_AVAIL = 30;
    public static final int CAM_NEVER_ASK_STORAGE_NOT_AVAIL = 31;
    public static final int CAM_NOT_AVAIL_STOARGE_NEVER_ASK = 32;
    public static final int CAM_STORAGE_NEVER_ASK = 33;

    public static HashMap<Integer, String[]> requestCodeMap = new HashMap<>();
    static {
        requestCodeMap.put(REQUEST_CAMERA, new String[] {Manifest.permission.CAMERA});
        requestCodeMap.put(REQUEST_LOCATION, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION});
        requestCodeMap.put(REQUEST_SMS, new String[] {Manifest.permission.READ_SMS});
        requestCodeMap.put(REQUEST_STORAGE, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});
        requestCodeMap.put(REQUEST_EMAIL, new String[]{Manifest.permission.GET_ACCOUNTS});
    }

    public static boolean hasPermission(int permissionCode, Context context) {
        if (context == null)
            return true;  //to avoid showing permission dialogs

        String[] permissions;
        switch (permissionCode){
            case PermissionUtils.REQUEST_LOCATION:
                permissions = new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
                break;

            case REQUEST_SMS:
                permissions = new String[] {Manifest.permission.READ_SMS};
                break;

            default:
                permissions = null;
        }

        if(permissions != null) {
            for (String permission : permissions) {
                if (PermissionChecker.checkSelfPermission(context, permission)
                        != PermissionChecker.PERMISSION_GRANTED) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void requestPermissions(int[] requestCodes, final Context context, int requestTag) {
        if (context == null)
            return;

        ArrayList<String> al = new ArrayList<>();
        String[][] per = new String[requestCodes.length][5];

        for(int i = 0; i < requestCodes.length; i++) {
            per[i] = requestCodeMap.get(requestCodes[i]);
            al.addAll(Arrays.asList(per[i]));
        }

        String[] permissions = new String[al.size()];
        permissions = al.toArray(permissions);

        if(shouldShowRPR(permissions, context)) {
            CommonLib.isPermissionDialogVisible = true;
            ActivityCompat.requestPermissions((Activity) context, permissions, requestTag);
        } else {
            if (!hasAskedBefore (requestCodes)) {
                CommonLib.isPermissionDialogVisible = true;
            }

            ActivityCompat.requestPermissions((Activity)context, permissions, requestTag);
        }
    }


    public static boolean shouldShowRPR(String[] permissions, Context context) {
        if(context == null)
            return false;

        for(String permission : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission)) {
                return true;
            }
        }
        return false;
    }


    public static Map<Integer, Boolean> getHasAskedBeforeMap() {
        Map<Integer, Boolean> hasAskedBefore = null;
        try {
            Type listType = new TypeToken<Map<Integer,Boolean>> () {}.getType();
            hasAskedBefore = DBWrapper.getObject(CommonLib.SharedPrefsKeys.HAS_ASKED_BEFORE, listType, null);
        } catch (Exception e) {

        }

        if(hasAskedBefore == null) {
            hasAskedBefore = new HashMap<> ();
        }

        return hasAskedBefore;
    }

    public static boolean hasAskedBefore(int permissionCode) {
        Map<Integer, Boolean> hasAskedBefore = getHasAskedBeforeMap();
        if (hasAskedBefore.get(permissionCode) != null)
            return hasAskedBefore.get(permissionCode);
        else
            return false;
    }

    public static boolean hasAskedBefore(int[] permissionCodes) {
        Map<Integer, Boolean> hasAskedBefore = getHasAskedBeforeMap();
        for (int code : permissionCodes) {
            if(hasAskedBefore.get(code) == null)
                return false;
        }
        return true;
    }


}
