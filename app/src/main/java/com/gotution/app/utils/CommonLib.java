package com.gotution.app.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;

import com.gotution.app.application.goTutionApp;
import com.gotution.app.auth.Verification;
import com.gotution.app.data.DBWrapper;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class CommonLib {
    public static final String APP_VERSION_NAME = "v1";

    public static final String DEFAULT_APP_VERSION = "default";

    public static final String RESOURCE_ID = "res_id";

    public static final String PROVIDER_NAME = "grofers://";

    public static final String DEFAULT_TUNNEL_HOST = "*.tunnel.grofer.io";

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 10000;

    public static final String DIALOG_LAST_SEEN = "last_seen";

    public static final String DEEPLINK_BRAND_SUGGESTION_TYPE = "5";

    public static final String SUPPORT = "support";

    public static HashMap<String, String> titleMap = new HashMap<String, String>() {{

        put("mr", "Mr.");
        put("mrs", "Mrs.");
        put("ms", "Miss");
    }};

    public static Boolean isPermissionDialogVisible = false;

    public static final int MIN_IMAGES_COUNT_DEFAULT = 1;

    public static final int MAX_IMAGES_COUNT_DEFAULT = 9;

    /**
     * The constant LOG_TAG.
     */
    private static final String LOG_TAG = CommonLib.class.getSimpleName();

    public static boolean isApiUpdated;

    /**
     * The constant ID_FACEBOOK_SIGNUP.
     */
    public static final int ID_FACEBOOK_SIGNUP = 994;
    /**
     * The constant ID_PHONE_VERIFICATION.
     */
    public static final int ID_PHONE_VERIFICATION = 995;
    /**
     * The constant ID_NO_STORES_FOUND.
     */
    public static final int ID_NO_STORES_FOUND = 996;
    /**
     * The constant ID_LOADING_FRAGMENT.
     */
    public final static int ID_LOADING_FRAGMENT = 997;

    /**
     * The constant ID_NO_INTERNET.
     */
    public final static int ID_NO_INTERNET = 998;
    /**
     * The constant ID_SERVER_ERROR.
     */
    public final static int ID_SERVER_ERROR = 999;
    /**
     * The constant ID_VERIFY_PHONE.
     */
    public static final int ID_VERIFY_PHONE = 1000;

    public static final int ID_UPDATE_MAP_LOCATION = 1001;

    public static final int ID_PLACE_ID_FAILED = 1002;

    public static final int ID_NO_CART_ITEMS = 1003;

    public static final int SEARCH_HISTORY_CACHE_SIZE = 15;

    public static final String CALL_FAILURE_TEXT = "Canceled";

    /**
     * The constant TAG_INTERNET_LOADING.
     */
    public static final String TAG_INTERNET_LOADING = "internet_loading";

    /**
     * The constant TAG_SERVER_ERROR.
     */
    public static final String TAG_SERVER_ERROR = "server_error";
    /**
     * The constant TAG_PHONE_VERIFICATION.
     */
    public static final String TAG_PHONE_VERIFICATION = "phone_verification";
    /**
     * The constant TAG_NO_INTERNET.
     */
    public static final String TAG_NO_INTERNET = "no_internet";

    public static final String TAG_NO_STORES_FOUND = "no_stores_found";
    /**
     * The constant PAYMENTMODE_INTENT_EXTRA.
     */
    public static final String PAYMENTMODE_INTENT_EXTRA = "paymentmode";
    /**
     * The constant API_KEY.
     */
    public static String API_KEY = "AIzaSyDUaMuf0hDHVMiefv9wlYDNSyRROPRWjoo";

    public static String API_KEY_SECONDARY = "AIzaSyCSENYYdPTA0RjwjxUw1L2bz9-An6Zi980";

    public static String RADIUS = "100000";

    public static final String NA = "NA";

    public static final String DEFAULT = "-NA-";

    public static final String DEFAULT_INT = "-1";

    public static final long DEFAULT_LONG = -1;

    /**
     * Image Bundle Constants
     */
    public static String CACHED_IMAGE_URL = "cachedImageUrl";

    public static String URL = "url";

    public static String SLIDERS = "Sliders";

    public static String POSTION = "position";

    public static String URL_ARRAY = "URL Array";

    public static String IMG_POSITION = "Image Position";

    public static String IMG_ANIMATION = "image_animation";

    /**
     * The constant TIMER_TIME.
     */
    public final static int TIMER_TIME = 500;
    /**
     * The constant MASTERCARD.
     */
    public static final String CARD_NAME_MASTERCARD = "mastercard";
    /**
     * The constant VISA.
     */
    public static final String CARD_NAME_VISA = "visa";
    /**
     * The constant AMERICAN_EXPRESS.
     */
    public static final String CARD_NAME_AMERICAN_EXPRESS = "amex";

    /**
     * The constant DINER.
     */
    public static final String CARD_NAME_DINER = "diner";

    /**
     * The constant DISCOVER.
     */
    public static final String CARD_NAME_DISCOVER = "discover";

    /**
     * The constant MAESTRO.
     */
    public static final String CARD_NAME_MAESTRO = "maestro";

    public static final String CARD_NAME_RUPAY = "rupay";

    public static final String CARD_NAME_UNKNOWN = "UNKNOWN";
    /**
     * The constant CVV_LENTH_AMERICAN_EXPRESS.
     */
    public static final int CVV_LENTH_AMERICAN_EXPRESS = 4;

    /**
     * The constant CVV_LENGTH_DEFAULT_CARD.
     */
    public static final int CVV_LENGTH_DEFAULT_CARD = 3;
    /**
     * The constant MAX_LENGTH_CARD_NUMBER_VISA_MASTERCARD.
     */
    public static final int MAX_LENGTH_CARD_NUMBER_VISA_MASTERCARD = 19;
    /**
     * The constant MAX_LENGTH_CARD_NUMBER_AMEX.
     */
    public static final int MAX_LENGTH_CARD_NUMBER_AMEX = 17;
    /**
     * The constant MAX_LENGTH_CARD_NUMBER_AMEX.
     */
    public static final int MAX_LENGTH_CARD_MAESTRO = 23;

    /**
     * The constant MAX_LENGTH_CARD_EXPIRY.
     */
    public static final int MAX_LENGTH_CARD_EXPIRY = 5;
    /**
     * The constant COD image url.
     */
    public static final String COD_IMAGE_URL = "http://cdn.grofers.com/app/uploads/payments/cod.png";
    /**
     * The constant Credit image url.
     */
    public static final String CREDIT_IMAGE_URL = "http://cdn.grofers.com/app/uploads/payments/credit.png";

    public static final String BACKGROUND = "background";

    public static final int VOICE_INTENT_REQUEST_CODE = 100;

    public static final int CHECKOUT_ADDRESS_SLOT_INTENT_REQUEST_CODE = 101;

    public static final String MERCHANT = "merchant";

    public static final String CITY_NAME = "name";

    public static final String LOCATION = "Location";

    public static final String PROMO_CODE = "promo";

    public static final String PROD_ID = "pid";

    public static final String SELLER_ID = "sid";

    public static final String DEEPLINK_EXPRESSION = "expr";

    public static final String COLLECTION_ID = "collection_id";

    public static final String RESTRICTED_MERCHANT = "restricted";

    public static final String CAT_ID = "cids";

    public static final String PLAY_STORE_URL = "http://play.google.com/store/apps/details?id=";

    public static final String PLAY_STORE_MARKET_URL = "market://details?id=";

    public static final String BADGE_TEXT = "badge_text";

    public static final String TAB_NAME = "tab_name";

    public static final String BADGE_COLOR_CODE = "badge_color_code";


    /**
     * Request key
     */
    public static final String REQUEST_KEY_PART2 = "b674-dee4";

    public static final String REQUESY_KEY_PART4 = "33b046cbf6f0";


    /**
     * The name of the SharedPreferences file
     */

    public static final String PREFS_FILE_NAME = "ReferralParams";

    public static final long SECOND = 1000;

    public static final long MINUTE = 60 * SECOND;

    public static final long HOUR = 60 * MINUTE;

    public static final long DAY = 24 * HOUR;

    public static final long WEEK = 7 * DAY;

    public static final long MONTH = 30 * DAY;

    public static final long SECONDS_IN_AN_HOUR = 3600;

    public static final String MASTER_CARD = "Master Card";
    public static final String VISA_CARD = "VISA Card";
    public static final String AMEX_CARD = "AMEX Card";
    public static final String DINER_CARD = "Diner Card";
    public static final String DISCOVER_CARD = "Discover Card";
    public static final String MAESTRO_CARD = "Maestro Card";
    public static final String RUPAY_CARD = "Rupay Card";
    public static final String USER_CARD = "User Card";

    public static final String SBC_GRATIFICATION_VIDEO_PATH = "sbc_add_to_cart_gratification.mp4";

    /**
     * Is valid email.
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean isValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }

    public static void changePlacesApiKey(String apiKey) {

        API_KEY = apiKey;
    }

    public static String removeQueryParamFromUri(Uri uri, String key) {
        if (uri != null) {
            Uri.Builder newUriBuilder = new Uri.Builder()
                    .scheme(uri.getScheme())
                    .authority(uri.getAuthority());
            if (ListUtils.isValidList(uri.getPathSegments())) {
                for (String pathSegment : uri.getPathSegments()) {
                    newUriBuilder.appendPath(pathSegment);
                }
            }
            if (uri.getQueryParameterNames() != null) {
                for (String queryKey : uri.getQueryParameterNames()) {
                    if (!key.equals(queryKey))
                        newUriBuilder.appendQueryParameter(queryKey, uri.getQueryParameter(queryKey));
                }
            }
            return newUriBuilder.build().toString();
        }
        return null;
    }

    public static class ApiPostBody {
        public static final String LIST_MERCHANTS = "list_merchants";

        public static final String SELECT_MERCHANT = "select_merchant";

        public static final String ACTION = "action";

        public static final String LEAF_CAT_IDS = "category_ids";

        public static final String MAPPING_ID = "mapping_id";

        public static final String MAPPING_IDS = "mapping_ids";

        public static final String MERCHANT_ID = "merchant_id";

        public static final String MERCHANT_IDS = "merchant_ids";

        public static final String CART_ITEMS = "cart_items";

        public static final String QUERY = "query";

        public static final String CONTEXT = "context";

        public static final String CONTEXT_SEARCH = "search_term";

        public static final String SOURCE = "source";

        public static final String SOURCE_SEARCH = "search";

    }

    public static class OrderStates {

        public static final String PROCESSING = "Placed";

        public static final String PROCESSED = "Placed";

        public static final String PROCURING = "Packed";

        public static final String PROCURED = "Packed";

        public static final String ENROUTE = "On the way";

        public static final String DELIVERED = "Delivered";
    }

    /**
     * Types of refund Transactions
     */
    public static class RefundTransactionTypes {

        public static final int TransactionTypeCashBack = 0;

        public static final int TransactionTypeRefferdSelf = 1;

        public static final int TransactionTypeRefferedOther = 2;

        public static final int TransactionTypePurchase = 3;

        public static final int TransactionTypeRefund = 4;

        public static final int TransactionTypeRefundReversal = 5;

        public static final int TransactionTypeCashout = 6;

        public static final int TransactionTypeNone = 7;


    }

    /**
     * The type Volley constants.
     */
    public static class VolleyConstants {
        /**
         * The constant DEFAULT_RETRIES.
         */
        public static final int DEFAULT_RETRIES = 3;
        /**
         * The constant DEFAULT_BACKOFF_MULT.
         */
        public static final float DEFAULT_BACKOFF_MULT = 2.0f;
        /**
         * The constant HIGH_TIMEOUT_MS.
         */
        public static final int DEFAULT_TIMEOUT_MS = 30000;

        public static final int SHORT_TIMEOUT_MS = 15000;

        public static final int LONG_TIMEOUT_MS = 60000;

        public static final int MIN_RETRIES = 0;

        public static final int MAX_RETRIES = 5;
    }

    /**
     * <p>These are the http status codes returned by our own server</p>
     */
    public static class HttpStatus {
        /**
         * The constant ACCESS_TOKEN_EXPIRED.
         */
        public static final int ACCESS_TOKEN_EXPIRED = HttpURLConnection.HTTP_UNAUTHORIZED;
        /**
         * The constant AUTH_KEY_EXPIRED.
         */
        public static final int AUTH_KEY_EXPIRED = HttpURLConnection.HTTP_FORBIDDEN;
        /**
         * The constant CART_NOT_FOUND.
         */
        public static final int CART_NOT_FOUND = HttpURLConnection.HTTP_NOT_FOUND;
    }



    /**
     * @param originalUri
     * @return pre-processed deeplink
     */
    public static String getPreProcessedDeepLink(String originalUri, String catId) {
        StringBuilder stringBuilder = new StringBuilder(originalUri);
        return CommonLib.getReplacedUri(stringBuilder.toString(), BundleConstants.CATEGORY_ID, catId);
    }



    /**
     * Is provider enabled.
     *
     * @param locationManager the location manager
     * @return the boolean
     */
    public static boolean isProviderEnabled(LocationManager locationManager) {
        return locationManager != null && (isGPSEnabled(locationManager) || isNetworkEnabled(locationManager));
    }

    /**
     * @param rating
     * @return
     */
    // TODO Return R.color.color_resource instead of color hex as string and Add @ColorRes
    // Or return int value of Color directly so that it isn't needed to parse it again.
    public static String getRatingColor(float rating) {
        if (rating == 0.0) {
            return "#cccccc";
        } else if (rating <= 2.0) {
            return "#F03737";
        } else if (rating <= 3.5) {
            return "#F5A623";
        } else return "#55AC20";
    }


    /**
     * Is network enabled.
     *
     * @param locationManager the location manager
     * @return the boolean
     */
    public static boolean isNetworkEnabled(LocationManager locationManager) {
        try {
            if (locationManager != null && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
                return true;
        } catch (Exception exception) {

        }

        return false;
    }

    /**
     * Is gPS enabled.
     *
     * @param locationManager the location manager
     * @return the boolean
     */
    public static boolean isGPSEnabled(LocationManager locationManager) {
        try {
            if (locationManager != null && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                return true;
        } catch (Exception exception) {

        }

        return false;
    }

    public static String getReplacedUri(String toBeUpdatedUri, String query, String newValue) {
        Uri uri = Uri.parse(toBeUpdatedUri);
        if (TextUtils.isEmpty(uri.getQueryParameter(query))) {
            return uri.buildUpon().appendQueryParameter(query, String.valueOf(newValue)).toString();
        } else {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(uri.getScheme());
            builder.authority(uri.getAuthority());

            Set<String> params = uri.getQueryParameterNames();
            Iterator iterator = params.iterator();
            while (iterator.hasNext()) {
                String param = (String) iterator.next();
                if (!TextUtils.isEmpty(param) && param.equalsIgnoreCase(query))
                    builder.appendQueryParameter(param, String.valueOf(newValue));
                else {
                    String value = uri.getQueryParameter(param);
                    builder.appendQueryParameter(param, value);
                }
            }
            return builder.toString();
        }
    }

    /**
     * Converts a {@link java.lang.Byte} array to hexadecimal string
     *
     * @param arr is the {@link java.lang.Byte} array to be converted to hexadecimal
     * @return a hexadecimal string
     */
    private static String byte2HexFormatted(byte[] arr) {
        StringBuilder str = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l = h.length();
            if (l == 1) h = "0" + h;
            if (l > 2) h = h.substring(l - 2, l);
            str.append(h.toUpperCase());
            if (i < (arr.length - 1)) str.append(':');
        }
        return str.toString();
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        return dp * (goTutionApp.getScreenDensityDpi() / 160f);
    }

    /**
     * Update product_message_dialog lat long shared preferences..
     */
    // TODO Check why this?
    public static void updateTempLatLongSharedPreferences() {
        DBWrapper.getInstance()
                .save(SharedPrefsKeys.LATITUDE_TEMP, DBWrapper.get(SharedPrefsKeys.LATITUDE, ""))
                .save(SharedPrefsKeys.LONGITUDE_TEMP, DBWrapper.get(SharedPrefsKeys.LONGITUDE, "")).close();
    }

    /**
     * Clear discount code shared preferences.
     */
    public static void clearScheduledSharedPreferences() {
        DBWrapper.getInstance().delete(SharedPrefsKeys.SCHEDULED_TIME).close();
    }

    /**
     * reverses any list of object of Type T
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> reverse(List<T> list) {
        int length = list.size();
        ArrayList<T> result = new ArrayList<T>(length);

        for (int i = length - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }

    /**
     * Clear discount code shared preferences.
     */
    public static void clearDiscountCodeSharedPreferences() {
        DBWrapper.getInstance().delete(SharedPrefsKeys.COUPON_CODE).close();
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / (metrics.densityDpi / 160f);
    }

    /**
     * converts an integer to device independent density pixel
     *
     * @param context is the application context
     * @param dps     is the
     *                to be converted
     * @return screen independent density pixels
     */
    public static int getDensityPixels(Context context, int dps) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }

    /**
     * Gets screen width.
     *
     * @param context the context
     * @return the screen width
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    /**
     * Gets screen height.
     *
     * @param context the context
     * @return the screen height
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    /**
     * Mail us.
     *
     * @param context the context
     * @return the intent
     * @throws ActivityNotFoundException the activity not found exception
     */
    public static Intent mailUs(Context context) throws ActivityNotFoundException {
        final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@grofers.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "[Customer] Feedback");
        String message = "";
        String name = DBWrapper.get(SharedPrefsKeys.USER_NAME, null);
        String phone = DBWrapper.get(SharedPrefsKeys.USER_PHONE, null);
        if (phone != null && phone.length() > 0) {
            message = message + phone;

            if (name != null && name.length() > 0)
                message = name + "\n" + message;

            message = "\n\n\nFrom:\n" + message;
        }

        intent.putExtra(Intent.EXTRA_TEXT, message);
        final PackageManager pm = context.getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
        ResolveInfo best = null;
        for (final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") ||
                    info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
        if (best != null)
            intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

        return intent;
    }

    /**
     * Handle exception.
     *
     * @param exception the exception
     */
    public static void handleException(Exception exception) {

    }

    /**
     * <p> Rate this app</p>
     *
     * @param context the context
     * @return the intent
     */
    public static Intent gotoPlayStore(Context context) {
        Intent intent;
        final String appPackageName = context.getPackageName();
        try {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_MARKET_URL + appPackageName));
        } catch (android.content.ActivityNotFoundException anfe) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_URL + appPackageName));
        }
        return intent;
    }

    /**
     * Gets type face icon font.
     *
     * @param context the context
     * @return the type face icon font
     */
    public static Typeface getTypeFaceCustomFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/custom.ttf");
    }

    /**
     * Gets type face Bold.
     *
     * @param context the context
     * @return the type face Bold
     */
    public static Typeface getTypeFaceBold(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Bold.otf");
    }

    /**
     * Gets type face Medium.
     *
     * @param context the context
     * @return the type face Medium
     */
    public static Typeface getTypeFaceMedium(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Medium.ttf");
    }

    /**
     * @param context the context
     * @return the type face Regular
     */
    public static Typeface getTypeFaceRegular(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Regular.ttf");
    }

    /**
     * Gets type face regular.
     *
     * @param context the context
     * @return the type face Light
     */
    public static Typeface getTypeFaceLight(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Light.ttf");
    }

    /**
     * Gets basic headers.
     *
     * @param context the context
     * @return the basic headers
     */
    public static Map<String, String> getBasicHeaders(Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put(Headers.AUTH_KEY, DBWrapper.get(SharedPrefsKeys.AUTH_KEY, Headers.REQUEST_KEY));
        headers.put(Headers.APP_VERSION, String.valueOf(Headers.appVersionCode));
        headers.put(Headers.VERSION_NAME, Headers.appVersionName);
        headers.put(Headers.APP_CLIENT, Headers.APP_CLIENT_VALUE);
        headers.put(Headers.SCREEN_DENSITY, goTutionApp.getDensityString());
        headers.put(Headers.SCREEN_DENSITY_NUM, String.valueOf(goTutionApp.getScreenDensity()));
        headers.put(Headers.DEVICE_ID, DBWrapper.get(DeviceInfoConstants.ANDROID_ID, null));
        headers.put(Headers.REGISTRATION_ID, DBWrapper.get(DeviceInfoConstants.REGISTRATION_ID, null));
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        String latitude = DBWrapper.get(CommonLib.SharedPrefsKeys.LATITUDE, null);
        String longitude = DBWrapper.get(CommonLib.SharedPrefsKeys.LONGITUDE, null);
        if (!TextUtils.isEmpty(latitude) && !TextUtils.isEmpty(longitude)) {
            headers.put("lat", latitude);
            headers.put("lon", longitude);
        }

        return headers;
    }

    /**
     * Gets authentication headers.
     *
     * @return the authentication headers
     */
    public static Map<String, String> getAuthenticationHeaders() {
        Map<String, String> headers = getBasicHeaders(goTutionApp.getContext());
        //headers.put(Headers.ACCESS_TOKEN, DBWrapper.get(SharedPrefsKeys.ACCESS_TOKEN, null));
        return headers;
    }

    /**
     * Gets formatted date.
     *
     * @param timeStamp the time stamp in seconds
     * @param format    the format
     * @return the formatted date
     */
    public static String getFormattedDate(long timeStamp, String format) {
        SimpleDateFormat outFmt = new SimpleDateFormat(format, Locale.ENGLISH);
        outFmt.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        Date date = new Date(timeStamp * 1000);
        return outFmt.format(date);
    }

    /**
     * Function to check if user is logged in or not
     *
     * @param context the context
     * @return boolean boolean
     */
    public static boolean isUserLoggedIn(Context context) {
        String userPhone = DBWrapper.get(CommonLib.SharedPrefsKeys.USER_PHONE, null);
        return (userPhone != null);
    }


    /**
     * Constants used for header to be passed in api calls
     */
    public static class Headers {
        /**
         * The constant appVersionName.
         */
        public final static String POST_BODY_VERSION_KEY = "version";

        public final static int POST_BODY_VERSION_VAL = 0;

        public final static int API_VERSION = 3;

        public final static String appVersionName = APP_VERSION_NAME;

        /**
         * The constant appVersionCode.
         */
        public final static String appVersionCode = "v1";
        /**
         * The constant SCREEN_DENSITY.
         */
        public static final String SCREEN_DENSITY = "screen_density";
        /**
         * The constant SCREEN_DENSITY NUMBER.
         */
        public static final String SCREEN_DENSITY_NUM = "screen_density_num";
        /**
         * The constant DEVIDE_ID
         */
        public static final String DEVICE_ID = "device_id";

        public static final String REGISTRATION_ID = "registration_id";
        /**
         * The constant REQUEST_KEY.
         */
        public static final String REQUEST_KEY = "req_key";
        /**
         * The constant AUTH_KEY.
         */
        public static final String AUTH_KEY = "auth_key";
        /**
         * The constant APP_VERSION.
         */
        public static final String APP_VERSION = "app_version";

        /**
         * The constant VERSION_NAME
         */
        public static final String VERSION_NAME = "version_name";

        /**
         * The constant APP_CLIENT.
         */
        public final static String APP_CLIENT = "app_client";
        /**
         * The constant APP_CLIENT_VALUE.
         */
        public final static String APP_CLIENT_VALUE = "consumer_android";

        /**
         * The constant VERIFY_CODE.
         */
        public static final String PAYLOAD = "payload";
        /**
         * The constant VERIFY_CODE.
         */
        public static final String SIGNATURE = "signature";
        /**
         * The constant VERIFY_CODE.
         */
        public static final String VERIFY_CODE = "verify_code";
        /**
         * The constant FACEBOOK_TOKEN.
         */
        public static final String FACEBOOK_TOKEN = "fbaccess_token";
        /**
         * The constant ACCESS_TOKEN.
         */
        public static final String ACCESS_TOKEN = "access_token";
        /**
         * The constant VERIFY_PHONE.
         */
        public static final String VERIFY_PHONE = "user_phone";
        /**
         * The constant LATITUDE.
         */
        public static final String LATITUDE = "lat";
        /**
         * The constant LONGITUDE.
         */
        public static final String LONGITUDE = "lon";
        /**
         * The constant IS_CURRENT_LOCATION.
         */
        public static final String IS_CURRENT_LOCATION = "is_current_location";
        /**
         * The constant USER_EMAIL.
         */
        public static final String USER_EMAIL = "user_email";
        /**
         * The constant USER_NAME.
         */
        public static final String USER_NAME = "name";

        /**
         * The constant USER_IMAGE.
         */
        public static final String USER_IMAGE = "image";
    }

    public static class DeviceInfoConstants {

        public static final String IS_REGISTRATION_SERVICE_ON = "is_registration_service_on";

        public static final String DEVICE_INFO = "device_info";

        public static final String ANDROID_ID = "android_id";

        public static final String PLAY_STORE_USER_EMAIL = "play_store_user_email";

        public static final String ADV_ID = "adv_id";

        public static final String IS_LIMIT_ENABLED = "adv_track";

        public static final String REGISTRATION_ID = "registration_id";

        public static final String DEFAULT = "-NA-";
    }

    public static class UserAttributeConstants {
        public static final String CART_COUNT = "cart_count";

        public static final String IS_FIRST_ORDER_DELIVERED = "is_first_order_delivered";

        public static final String IS_DEVICE_ID_NEW = "is_device_id_new";

        public static final String IS_UNDELIVERED_ORDER_PRESENT = "is_undelivered_order_present";

        public static final String IS_FIRST_ORDER_PLACED = "is_first_order_placed";
    }

    public static final String DELIMITER = "|";

    public static class MoEngage {

        public static final String ORDER_RATED = "Order Rated";

        public static final String PROMOTION_ID = "banner_id";

        public static final String SEPARATOR_2 = "-";

        public static final String PLATFORM = "Platform";

        public static final String DEVICE_MODEL = "Name-Model";

        public static final String WEEKDAY = "Day of Week";

        public static final String HOUR = "Hour of Day";

        public static final String APP_VERSION = "App Version (G)";

        public static final String LOCATION = "Location";

        public static final String REGISTRATION_ID = "Registration ID";

        public static final String OS = "OS";

        public static final String CART_COUNT = "Cart Count";

        public static final String TAG_PRODUCT_ID = "Product ID";

        public static final String TAG_MERCHANT_ID = "Merchant ID";

        public static final String TAG_MERCHANT_NAME = "Merchant Name";

        public static final String TAG_BANNER_ID = "Banner ID";

        public static final String TAG_SOURCE = "Source";

        public static final String TAG_MERCHANT_ID_LIST = "Merchant IDs";

        public static final String TAG_MERCHANT_NAME_LIST = "Merchant Names";

        public static final String TAG_PRODUCT_ID_LIST = "Product IDS";

        public static final String TAG_PRODUCT_NAME_LIST = "Product Names";

        public static final String TAG_MAPPING_ID_LIST = "Mapping IDS";

        public static final String TAG_ROOT_CAT_ID_LIST = "Root Category IDS";

        public static final String TAG_SUB_CAT_ID_LIST = "Sub Category IDS";

        public static final String TAG_ORDER_AMOUNT = "Order Amount";

        public static final String TAG_PAYMENT_MODE = "Payment Mode";

        public static final String TAG_USED_GROFERS_CASH = "Used Grofers Cash";

        public static final String TAG_TOTAL_AMOUNT_PAID = "Amount Paid";

        public static final String TAG_COUPON_CODE = "Coupon Code";

        public static final String USER_ATTRIBUTE_MEMBERSHIP_NAME = "plan_name";

        public static final String USER_ATTRIBUTE_MEMBERSHIP_EXPIRY = "plan_expiry";

        public static final String USER_EMAIL_ID = "user_email_id";
    }

    public static class EventBus {
        public static final int TOOLBAR_SHOW_SUBTITLE = 0;
        public static final int TOOLBAR_HIDE_SUBTITLE = 1;
        public static final int API_MERCHANT_INFO = 2;
        public static final int API_PRODUCT_DATA = 3;
        public static final int POSITIVE_CLICK = 4;
        public static final int NEGATIVE_CLICK = 5;
        public static final int OPEN_DOC_TYPE_CHOOSER = 6;
        public static final int NUM_IMAGE_CHANGE = 7;
        public static final int SLIDING_PANEL_CLOSE = 8;
        public static final int SLIDING_PANEL_OPEN = 9;
        public static final int CATEGORY_EXPAND_CLICK = 10;
        public static final int FINISH_ACTIVITY = 11;
        public static final int LOAD_LEAF_FRAGMENT = 12;
        public static final int PICK_LOCALITY = 13;
        public static final int TOGGLE_NAVIGATION_DRAWER = 14;
        public static final int SEARCH_CAT_CHANGE = 15;
        public static final int OPEN_L0_CATEGORY = 16;
        public static final int TAB_RESET = 17;
        public static final int ADDRESS_EXCEPTION = 18;
        public static final int LOAD_AUTO_FRAGMENT = 19;
        public static final int GRID_EXPAND_CLICK = 20;
    }

    public static class IntentId {
        public static final int INTENT_PRODUCT_POPUP = 0;
        public static final int INTENT_DOC_CHOOSER = 1;
        public static final int INTENT_TEMPLATE = 2;
        public static final int INTENT_HELP_TOPICS = 3;
    }

    public static class SearchSuggestionTypeForTracking {
        public static final int SuggestionTypeNone = 0;
        public static final int SuggestionTypeSubcategory = 1;
        public static final int SuggestionTypeMerchant = 2;
        public static final int SuggestionTypeSuggestion = 3;
        public static final int SuggestionTypeProduct = 4;
        public static final int SuggestionTypeCategory = 5;
    }

    public static String getWeekDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        return dayOfTheWeek;
    }

    public static String getDayHour() {
        SimpleDateFormat sdf = new SimpleDateFormat("H");
        Date d = new Date();
        return sdf.format(d);
    }

    public static String getDisplayTime(int timestamp) {
        return getDisplayTime(String.valueOf(timestamp));
    }

    public static String getDisplayTime(String timestamp) {
        Date dt = new Date(Long.parseLong(timestamp));
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        String time = sdf.format(dt);
        return time;
    }

    /**
     * Function to convert text to a bitmap image
     *
     * @param text      is the text to be converted to bitmap
     * @param textSize  is the size of text for bitmap image
     * @param textColor is the color of text for bitmap image
     * @return text as a bitmap image
     */
    public static Bitmap textAsBitmap(String text, float textSize, int textColor) {
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        int width = (int) (paint.measureText(text) + 0.5f); // round
        float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
        int height = (int) (baseline + paint.descent() + 0.5f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint);
        return image;
    }

    public static class CashbackStates {
        public static final int PENDING = 0;

        public static final int COMPLETE = 1;

        public static final int INVALID = -1;

        public static final int CANCEL = 2;
    }

    public static class DBNames {
        public static final String Navigation = "Navigation";
        public static final String ProductPopups = "ProductPopups";
    }

    /**
     * Constants used for saving data to shared preferences
     */
    public static class SharedPrefsKeys {

        public static final String SESSION_KEY = "session_key";

        public static final String HAS_ASKED_BEFORE = "has_asked_before";

        public static final String POPUP_SESSION_TIME = "popup_session_time";

        public static final String CUSTOM_STORAGE_PERM_SESSION = "custom_storage_permission_dialog_session";

        public static final String SHOW_SYSTEM_PERMISSION_LAUNCH_DIALOG = "show_system_perm_launch_dialog";

        public static final String DIALOG_PRIORITY_LAST_SEEN = "dialog_priority_last_seen";

        public static final String IS_FIRST_LAUNCH = "is_first_launch";

        public static final String SENT_TOKEN_TO_SERVER = "sent_token_to_server";

        public static final String FETCH_NOTIFICATIONS_SINCE = "fetch _notifications_since";
        public static final String CDN_BASE_URL = "cdn_base_url";
        public static final String CDN_BUCKET = "cdn_bucket";
        public static final String VERIFICATION_NUMBER = "verification_number";
        public static final String HELPLINE = "helpline";
        public static final String CITIES_STRING = "cities_string";
        public static final String SHOW_ONBOARDING = "show_onboarding";
        public static final String API_AUTHORITY = "api_authority";
        public static final String API_SCHEME = "api_scheme";
        public static final String API_TUNNEL_HOST = "api_tunnel_host";
        public static final String LAST_TIME_POPUP_SHOWN = "last_popup_time";
        public static final String SHOW_WRITE_TO_US = "show_write_to_us";
        public static final String SHOW_REPORT_BUG = "show_report_bug";
        public static final String PRODUCT_POPUPS = "product_popups";
        public static final String OFFER_ZONE_LAST_VISIT_TS = "offer_zone_last_visit_ts";
        public static final String TOOLTIP_WIDGET = "tooltip_widget";
        public static final String AFTER_UPDATE_NEW_LAUNCH_TIME = "new_launch_time_after_update";
        public static final String ABOUT_THIS_RELEASE_SESSION_TIME = "about_this_release_session_time";
        public static final String SHOW_CHAT_WITH_US = "show_chat_with_us";
        public static final String IS_PERMISSION_DIALOG_SHOWN = "is_permission_dialog_shown";


        /**
         * Min Delivery overlay related prefs keys.
         */
        public static final String REORDER_ELIGIBLE = "reorder_eligible";

        public static final String IS_RED_DISMISSED = "is_red_dismissed";

        public static final String IS_GREEN_DISMISSED = "is_green_dismissed";

        public static final String IS_MIN_ORDER_POPUP_DISMISSED = "is_min_order_popup_dismissed";

        public static final String APP_CITY = "app_city";

        public static final String SOURCE_FAQ = "fromFAQ";

        public static final String OPEN_SUPPORT = "open support";

        public static final String PREFERRED_ADD_ID_FOR_CHECKOUT = "add_id_for_checkout";

        public static final String LAST_CHECKED_OUT_ADDRESS = "last_checked_out_add";

        public static final String LAST_SAVED_VERSION_NUMBER = "last_saved_version_number";

        public static final String SHOW_IN_APP_OPTION = "show_in_app_view_details_option";

        /**
         * The constant CURRENT_ADDRESS.
         */
        public static final String CURRENT_ADDRESS = "current_address";
        /**
         * The constant LOCALITY.
         */
        public static final String LOCALITY = "locality";
        /**
         * The constant LOCALITY.
         */
        public static final String CITY = "city";

        public static final String MOENGAGE_CITY = "City";
        /**
         * The constant LATITUDE.
         */
        public static final String LATITUDE = "latitude";

        public static final String LAST_KNOWN_LATITUDE = "last_known_lat";
        public static final String LAST_KNOWN_LONGITUDE = "last_known_lon";
        /**
         * The constant LATITUDE_TEMP.
         */
        public static final String LATITUDE_TEMP = "latitudetemp";
        /**
         * The constant LONGITUDE.
         */
        public static final String LONGITUDE = "longitude";

        public static final String LOCALITY_EDGE = "locality_edge";
        /**
         * The constant LONGITUDE_TEMP.
         */
        public static final String LONGITUDE_TEMP = "longitudetemp";
        /**
         * The constant LOCATION_SOURCE.
         */
        public static final String LOCATION_SOURCE = "location_source";
        /**
         * The constant USER_PHONE.
         */
        public static final String USER_PHONE = "cell";

        public static final String IS_BABA = "is_baba";

        public static final String USER_WALLET_PREF_PHONE = "one_tap_pref_number";
        /**
         * The constant STARTED_FIRST_TIME.
         */
        public static final String IS_SESSION_START = "is_session_start"; //to read unique session
        /**
         * The constant ORDER_ID.
         */
        public static final String ORDER_ID = "orderid";
        /**
         * The constant USER_EMAIL.
         */
        public static final String USER_EMAIL = "email";

        /**
         * The constant USER_ID
         */
        public static final String USER_ID = "user_id";
        /**
         * The constant ADDRESS_ID.
         */
        public static final String ADDRESS_ID = "id";
        /**
         * The constant APK_RELOADLING.
         */
        public static final String APK_TRACKING = "apk_reloading";
        /**
         * The constant AUTH_KEY.
         */
        public static final String FEED_INFO_DIALOG = "feed_info_dialog";
        /**
         * The constant AUTH_KEY.
         */
        public static final String AUTH_KEY = "auth_key";

        public static final String LOCALITY_TOOLTIP_SHOWN = "loc_tool_tip_shown";

        public static final String SHOULD_SHOW_TOOL_TIP = "should_show_tooltip";

        public static final String ORDER_CLICKED = "order_clicked";
        /**
         * The constant REGISTRATION_ID.
         */
        public static final String REGISTRATION_ID = "registration_id";
        /**
         * The constant ACCESS_TOKEN.
         */
        public static final String ACCESS_TOKEN = "access_token";

        /**
         * The constant WALLET_ID
         */
        public static final String WALLET_ID = "wallet_id";
        /**
         * The constant USER_IMAGE.
         */
        public static final String USER_IMAGE = "user_image";
        /**
         * The constant USER_NAME.
         */
        public static final String USER_NAME = "user_name";
        /**
         * The constant COUPON_CODE.
         */
        public static final String COUPON_CODE = "coupon_code";
        /**
         * The constant SCHEDULED_TIME.
         */
        public static final String SCHEDULED_TIME = "user_scheduled_time";

        public static final String IS_LOCATION_CHANGED = "location_changed";

        public static final String SHOW_CALL_US = "show_call_us";

        public static final String LOCATION_CHANGED_RADIUS = "loc_radius";

        public static final String LOC_CHANGED_POPUP_TIME = "loc_change_time";

        public static final String LOC_CHANGED_POPUP_INTERVAL = "loc_change_interval";

        /* If Cart contains any Undelivered Orders */
        public static final String ORDERS_STATUS = "orders_status";

        public static final String SEARCH_HISTORY = "search_history";

        public static final String LAST_CHAT_TIMESTAMP = "last_chat_timestamp";

        public static final String FRESHCHAT_RESTORE_ID_PREFIX = "freshchat_restore_id";


        public static final String REACT_APP_KEYS = "react_app_keys";

        public static final String IS_STORAGE_DENIED_BEFORE = "is_storage_denied_before";

        public static final String LAST_INDEXED_TIMESTAMP = "last_indexed_timestamp";

        public static final String SESSION_CART_START_TIMESTAMP = "session_cart_start_timestamp";

        public static final String SESSION_APP_LAUNCH_TIMESTAMP = "session_app_launch_timestamp";

        public static final String SESSION_APP_LENGTH_TIMER_SEC = "session_app_length_timer_sec";

        public static final String HAS_USER_RATED_ON_PLAYSTORE = "has_user_rated_on_playstore";

        public static final String APP_LAUNCH_COUNT = "app_launch_count";

        public static final String SHOW_RATE_US_ON_HOME_PAGE = "show_rate_us_on_home_page";

        public static final String LAST_LAUNCH_TIMESTAMP = "last_launch_timestamp";

        public static final String APP_RATING_DENIED_TIMESTAMP = "app_rating_denied_timestamp";

        public static final String SHOW_CART_UPSELL_WIDGET = "show_cart_upsell_widget";

        public static final String CITY_ID = "city_id";

        public static final String SHOW_PRODUCT_RECOMMENDATION = "show_product_recommendation";

        public static final String LAST_AUTO_ADDITION_TIME = "last_auto_addition_time";

        public static final String LAST_AUTO_ADDITION_PRODUCT = "last_auto_addition_product";
    }

    public static class OrderHistory {

        public static final int TYPE_CHECKOUT_DATE = 0;

        public static final int TYPE_SCHEDULE_SLOT = 1;

        public static final int TYPE_ORDER_PROCESSED = 2;

        public static final int TYPE_ORDER_PROCESSING = 3;

        public static final int TYPE_PAYMENT_INFO = 4;

        public static final int TYPE_FOOTER = 5;

        public static final int TYPE_CASHBACK = 6;

        public static final int TYPE_REFUND = 7;

        public static final int TYPE_VIEW_DETAILS = 8;

        public static final int TYPE_VIEW_DETAILS_SHOW_IN_APP = 9;
    }

    public static class OrderDetailNew {

        public static final int TYPE_HEADER = 1;

        public static final int TYPE_ORDER_HEADER = 2;

        public static final int TYPE_ORDER_HEADER_SUMMARY = 3;

        public static final int TYPE_ITEM = 4;

        public static final int TYPE_PAYMENT_SUMMARY = 5;

        public static final int TYPE_REFUND_SUMMARY = 6;

        public static final int TYPE_SAVINGS_SUMMARY = 7;

        public static final int TYPE_ORDER_FOOTER_ADDRESS = 8;

        public static final int TYPE_ORDER_FOOTER_STORE = 9;

        public static final int TYPE_ORDER_FOOTER_CANCEL = 10;
    }

    public static class InAppOrderStatus {

        public static final int TYPE_HEADER = 1;

        public static final int TYPE_ORDER_HEADER = 2;
    }

    public static class CategoryLevels {
        public static final String CATEGORY_L0 = "0";
        public static final int CATEGORY_L0_INT = 0;
        public static final int CATEGORY_L1_INT = 1;
        public static final int CATEGORY_L2_INT = 2;
    }

    public static class SecondaryFilters {

        public static final String FILTER_NEW_OFFER = "new_offer";
        public static final String FILTER_SHOW_CART_UPSELL = "show_cart_upsell";
        public static final String FILTER_CITY_ID = "city_id";
        public static final String SKU_AUTO_ADD = "sku_auto_add";
        public static final String CART_BANNER_IMAGE = "cart_banner_image";
        public static final String SBC_PROMOTION_DATA = "sbc_promotion_data";
    }

    /**
     * Contents defined for passing data in bundles
     */
    public static class BundleConstants {
        public static final String HAS_CATEGORIES = "has_categories";

        public static final String OPEN_PRODUCT_ITEM_SELECTION = "show_selection";

        public static final String CHAT_UNAVAILABLE_MESSAGE = "chat_unavailable_message";

        public static final String SCREEN_NAME = "screen_name";

        public static final String ONE_TAP_OTP_REQUEST = "paytm_one_tap_otp_request";

        public static final String RATE_DELIVERY = "rate_delivery";

        public static final String DELIVERY_CHARGE = "delivery_charge";

        public static final String CANCEL_REASONS = "cancel_reasons";

        /**
         * url of the webview
         */
        public static final String WEBVIEW_URL = "webViewUrl";

        public static final String SEARCH_PRODUCT_RESPONSE = "search_prod_response";

        public static final String STORE_SEARCH_WIDGET_OBJECT = "store_search_widget";

        public static final String CHANGE_STORE = "change_store";

        /**
         * source of the activity
         */
        public static final String SOURCE = "source";

        public static final String LAST_REFRESH_TIMESTAMP = "last_refresh_timestamp";

        public static final String REQUEST_ID = "request_id";

        public static final int BACKPRESS = 0;

        public static final int CART_ICON = 1;

        public static final int SEARCH_ALL = 2;

        /**
         * The constant CURRENT_ADDRESS.
         */
        public static final String CURRENT_ADDRESS = "current_address";
        /**
         * The constant LOCATION_SOURCE.
         */
        public static final String LOCATION_SOURCE = "location_source";


        public static final String DIALOG_NAME = "dialog_name";

        /**
         * The constant PHONE.
         */
        public static final String PHONE = "phoneNumber";
        /**
         * The constant ADDRESS.
         */
        public static final String ADDRESS = "address";

        public static final String IS_EDIT_ADDRESS = "is_edit_address";
        /**
         * The constant ADDRESSES_ALL
         */
        public static final String ADDRESSES_ALL = "addresses_all";
        /**
         * The constant ADDRESSES which are enabled for Checkout.
         */
        public static final String ADDRESS_ENABLED = "address_enabled";
        /**
         * The constant ADDRESSES which are disabled for Checkout..
         */
        public static final String ADDRESS_DISABLED = "address_diabled";

        public static final String LOCALITY_SEARCH_RESULT_TEXT = "locality_search_result_text";

        /**
         * The constant PRODUCT_LISTING.
         */
        public static final String CATEGORY = "category";

        public static final String CITY_ID = "city_id";
        /**
         * The constant LATITUDE.
         */
        public static final String LATITUDE = "latitude";

        /**
         * The constant LONGITUDE.
         */
        public static final String LONGITUDE = "longitude";

        /**
         * The constant CATEGORY_NAME.
         */
        public static final String CATEGORY_NAME = "category_name";

        public static final String COLLECTION_NAME = "collection_name";

        public static final String SHARED_ELEMENT_HEIGHT = "height";

        public static final String WIDGETS = "widgets";

        public static final String DEEPLINK_RESPONSE = "deeplink_response";

        public static final String IS_TABBED_HEADER = "is_tabbed_header";

        /**
         * The constant SUBCATEGORY.
         */
        public static final String SUBCATEGORY = "subcategory";
        public static final String SUBCATEGORY_NAME = "subcategory_name";
        public static final String MERCHANT_HEADER_HEIGHT = "merchant_header_height";
        public static final String TOOLTIP_HEIGHT = "tooltip_height";
        /**
         * The constant CATEGORY_ID.
         */
        public static final String CATEGORY_ID = "category_id";

        public static final String CATEGORY_L2_ID = "category_l2_id";

        public static final String IS_UNIVERSAL_SEARCH = "universal_search";

        public static final String SEARCH_SUGGESTION_TYPE = "suggestion_type";

        public static final String SHIPMENT_POSITION = "shipment_position";

        public static final String ADAPTER_POSITION = "adapter_position";

        public static final String FROM_MOENGAGE = "from_moengage";

        public static final String CATEGORY_LEVEL = "category-level";

        public static final String CALLING_ACTIVITY = "calling_activity";

        public static final String SHIPMENT_STATUS = "shipment_status";

        public static final String CATEGORY_POSITION = "category_position";
        /**
         * The constant MERCHANT.
         */
        public static final String MERCHANT = "merchant";

        public static final String CART_MERCHANT = "cart_merchant";

        public static final String PRICING = "pricing";

        public static final String TOTAL_COST = "total_cost";

        public static final String TOTAL_MRP = "total_mrp";

        public static final String TOTAL_SBC_SAVINGS = "total_sbc_savings";

        public static final String TOTAL_GROFERS_SAVINGS = "total_grofers_savings";

        public static final String CART_PROMO_TITLE = "cart_promo_title";

        public static final String CART_PROMO_BODY = "cart_promo_body";

        public static final String PRODUCT_ROW_BG = "product_row_bg";

        public static final String SHOW_DIVIDER = "show_divider";

        public static final String MARGIN_TOP = "margin_top";

        public static final String MERCHANT_IDS = "merchant_ids";

        public static final String COLLECTION = "collection";

        public static final String CART_OBJECT = "cart_object";

        public static final String CART_ITEM_IDS = "cart_item_ids";

        public static final String SHOULD_FIND_SIMILAR_ITEMS = "should_find_similar_items";

        /**
         * The constant PRODUCT.
         */
        public static final String PRODUCT = "product";

        public static final String OUT_OF_STOCK_PRODUCT_COUNT = "out_of_stock_product_count";

        public static final String SHOW_VIEW_ALL_BUTTON = "show_view_all_button";
        /**
         * The constant USER.
         */
        public static final String USER = "user";

        /**
         * The constant LOADING_TEXT.
         */
        public static final String LOADING_TEXT = "loading_text";

        public static final String LOADING_COLOR = "loading_color";

        /**
         * The constant is used to detect if app is started from notification
         */
        public static final String FROM_NOTIFICATION = "from_notification";

        public static final String NOTIFICATION_TYPE_ID = "notification_id";

        /**
         * The constant denoted whether notification action button was clicked
         */
        public static final String NOTIFICATION_ACTION_MAIN = "notification_action_main";

        public static final String NOTIFICATION_BUNDLE = "notification_bundle";
        /**
         * The constant COUPON_CODE.
         */
        public static final String COUPON_CODE = "coupon_code";
        /**
         * The constant URL.
         */
        public static final String URL = "about_us_url";

        /**
         * The constant TITLE.
         */
        public static final String TITLE = "privacy_policy";

        /**
         * The constant CHECKOUT_RESPONSE.
         */
        public static final String CHECKOUT_RESPONSE = "chekout_response";
        /**
         * The constant CART_ID.
         */
        public static final String CART_ID = "cart_id";

        public static final String TRANSACTION_ID = "txn_id";

        public static final String ORDER_ID = "order_id";

        /**
         * The constant CARD.
         */
        public static final String CARD = "card";
        /**
         * The constant USER_EMAIL.
         */
        public static final String USER_EMAIL = "user_email";
        /**
         * The constant PAYMENT_TYPE.
         */
        public static final String PAYMENT_TYPE = "payment_type";

        public static final String EVENT = "event";
        /**
         * The constant FAQ_RESULTS.
         */
        public static final String FAQ_RESULTS = "faq_results";

        public static final String FAQ_META = "faq_meta";

        /**
         * The constant CART.
         */
        public static final String CART = "cart";

        public static final String ORDERED_ITEM = "ordered_item";

        public static final String MARGIN_HORIZONTAL = "margin_horizontal";


        /**
         * The constant MERCHANT_ID.
         */
        public static final String MERCHANT_ID = "merchant_id";

        public static final String PREFERRED_MERCHANT_ID = "preferred_merchant_id";

        /**
         * The constant ADDRESS_ID.
         */
        public static final String ADDRESS_ID = "address_id";
        /**
         * The constant DELIVERY_DATE.
         */
        public static final String DELIVERY_DATE = "delivery_date";
        /**
         * The constant DELIVERY_TIME.
         */
        public static final String DELIVERY_TIME = "delivery_time";

        /**
         * The constant FEEDBACK_FROM_NOTIFICATION.
         */
        public static final String FEEDBACK_FROM_NOTIFICATION = "feedback_from_notification";

        /**
         * The constant AMOUNT.
         */
        public static final String AMOUNT = "amount";
        public static final String CITY = "city";
        public static final String LOCALITY = "locality";
        public static final String OLD_CITY = "old_city";
        public static final String OLD_LOCALITY = "old_locality";
        public static final String FEED_PAGE_FIRST_RESPONSE = "feed_page_first_response";
        public static final String FEED_PAGE_LIST = "feed_page_list";
        public static final String FEED_PAGE_NUMBER = "feed_page_number";
        public static final String SEARCH_PHRASE = "query";
        public static final String SEARCH_PRODUCT_ID = "product_id";
        public static final String WEBSITE_SEARCH_PHRASE = "q";
        public static final String SEARCH_WIDGET_RESULT = "search_widget_result";
        public static final String FEED_SIMPLE_DIALOG = "feed_simple_dialog";
        public static final String OFFER_COUNT = "offer_count";
        public static final String DEEPLINK_URI = "deeplinked_uri";
        public static final String DEEPLINK_TYPE = "type";
        public static final String FROM_DEEPLINK = "from deeplink";
        public static final String SHIPMENTS = "shipments";
        public static final String SHIPMENT = "shipment";
        public static final String SHIPMENT_ID = "shipmentId";
        public static final String DOCUMENT_NAME = "documentName";
        public static final String EXTERNAL_WEB_URL = "web_url";

        public static final String WEB_TITLE = "grtitle";
        public static final String WEB_CACHE_ENABLED = "isGrWebCacheEnabled";
        public static final String COOKIES_ENABLED = "isGrWebCookieEnabled";
        public static final String INTERNAL_WEB_URL = "url";
        public static final String INTERNAL_WEB_TITLE = "grtitle";
        public static final String HTML_DATA = "html-data";

        public static final String ITEM_NAME = "item_name";
        public static final String PRODUCT_MESSAGE = "product_message";
        public static final String MESSAGE_LIMIT = "message_limit";
        public static final String MAPPINGID = "mappingID";

        public static final String CAMERA_STATE = "camera_state";
        public static final String IMAGE_URL = "image_url";
        public static final String SHOW_ORDERS = "show_orders";
        public static final String MESSAGE_LIST = "message_list";
        public static final String COMMENT_MANDATORY = "comment_mandatory";
        public static final String AUTOMATED_REPLY = "automated_reply";
        public static final String PRODUCT_SELECTOR_TEXT = "product_selector_text";
        public static final String UPDATED_ORDERS = "updated_orders";
        public static final String WITH_CROSS = "with_cross";
        public static final String IMAGE_POSITION = "image_position";
        public static final String AWSS3DATA = "awss3data";
        public static final String S3_TEMP_FILE_UPLOAD_DETAILS = "s3_temp_file_upload_details";
        public static final String ACTIVITY_HANDLER = "activity_handler";
        public static final String IMAGE_DETAIL_URLS = "image_detail_urls";
        public static final String HELP_TEXT = "helpText";
        public static final String HELP_ID = "helpId";
        public static final String FEEDBACK_TYPE = "feedbackType";
        public static final String CURRENT_SLOT = "current_slot";
        public static final String SLOT_START = "slot_start";
        public static final String SLOT_END = "slot_end";
        public static final String REPORT_TYPE = "reportType";
        public static final String MESSAGE = "message";
        public static final String USE_SLOTS = "useSlots";
        public static final String SLOTS = "slots";
        public static final String SUBMIT_BUTTON_TEXT = "submit_button_text";
        public static final String COMMENT_PLACEHOLDER = "comment_placeholder";
        public static final String TO_REFRESH = "toRefresh";
        public static final String IS_CANCELABLE = "is_cancelable";
        public static final String SHOW_TOOLBAR = "show_toolbar";
        public static final String SUPPORT_TYPE = "show_chat_in_app_support";
        public static final String API_CALL_ID = "api_call_id";
        public static final String IS_SLOT_UPGRADED = "is_slot_upgraded";

        public static final String IAS_USER_ENTERED_PRICE = "ias_user_entered_price";

        public static final int STORE_SEARCH_404 = 653;

        public static final String MIN_IMAGE_COUNT = "min_image_count";
        public static final String MAX_IMAGE_COUNT = "max_image_count";
        public static final String ITEM_LIST_SIZE = "item_list_size";
        public static final String IS_SUGGESTION_LOADING = "is_suggestion_loading";

        public static final String SELECT_ITEM_TYPE = "select_item_type";
        public static final String GRIEVANCE_API_SUPPORT = "grievance_api_support";
        public static final String IMAGE_PROOF_MANDATORY = "image_proof_mandatory";
        public static final String IAS_CHAT_DEFAULT_MESSAGE = "ias_chat_default_message";

        public static final String IS_STARTED_FOR_RESULT = "is_started_for_result";


        /*
        USED TO STORE THE LAST SELECTED PAYMENT TAB ID
         */
        public static final String LAST_SELECTED_PAYMENT_TAB_ID = "last_selected_payment_tab_id";
        public static final String ACTION = "action";
        public static final String HELP = "help";
        public static final String HELP_LIST = "help_list";
        public static final String GRIEVANCE_RESPONSE = "grievance_response";
        public static final String CHAT_WITH_US_TAG = "chat_with_us_tag";
        public static final String CHAT_SUFFIX = "chat_suffix";

        public static final String VISA_TAB_OPTION_CALL_ID = "visa_tab_option_call_id";
        public static final String PRODUCT_WIDGET_ATTRIBUTES = "product_widget_attributes";
        public static final String NEED_REFRESH_ADAPTER = "need_refres";

        public static final String DIALOG_ICON = "dialog_icon";
        public static final String DIALOG_ICON_VIDEO = "dialog_icon_video";
        public static final String DIALOG_TITLE = "dialog_title";
        public static final String DIALOG_SUBTITLE = "dialog_subtitle";
        public static final String DIALOG_POSITIVE_TEXT = "dialog_positive_text";
        public static final String DIALOG_NEGATIVE_TEXT = "dialog_negative_text";
        public static final String QUERY_SOURCE = "query_source";
        public static final String PREVIOUSLY_BOUGHT_RESPONSE = "previously_bought_response";

        public static final String WIDGET_LAYOUT_ID = "widget_layout_id";
    }

    public static boolean passCaptureImageMaxCount(int imagesListSize, int maxImageCount) {
        return (imagesListSize < maxImageCount);
    }

    /**
     * The type Pay u constants.
     */
    public static class PayUConstants {
        /**
         * The constant COMMAND.
         */
        public static final String COMMAND = "command";
    }

    /**
     * Constants for PaytM wallet
     */
    public static final class PayTm {

        public static final String REQUEST_TYPE = "REQUEST_TYPE";

        public static final String ORDER_ID = "ORDER_ID";

        public static final String MERCHANT_ID = "MID";

        public static final String CUST_ID = "CUST_ID";

        public static final String CHANNEL_ID = "CHANNEL_ID";

        public static final String INDUSTRY_TYPE_ID = "INDUSTRY_TYPE_ID";

        public static final String WEBSITE = "WEBSITE";

        public static final String THEME = "THEME";

        public static final String EMAIL = "EMAIL";

        public static final String MOBILE_NO = "MOBILE_NO";

        public static final String TXN_AMOUNT = "TXN_AMOUNT";

        public static final String MERCHANT_ID_VALUE = "GROFER57242793868794";

        public static final String WEBSITE_VAL = "GROFERSwap";

        public static final String REQ_TYPE_VAL = "DEFAULT";

        public static final String CALLBACK_URL = "CALLBACK_URL";

    }

    /**
     * The type Payment details.
     */
    public static final class Zaakpay {
        /**
         * The type Request.
         */
        public static class Request {
            /**
             * The constant ORDER_ID.
             */
            public static final String ORDER_ID = "orderid";
        }

        /**
         * The type Response.
         */
        public static final class Response {
            /**
             * The constant STATUS_CODE.
             */
            public static final String STATUS_CODE = "statuscode";
            /**
             * The constant ORDER_ID.
             */
            public static final String ORDER_ID = "orderid";
            /**
             * The constant AMOUNT.
             */
            public static final String AMOUNT = "amount";
            /**
             * The constant STATUS_MESSAGE.
             */
            public static final String STATUS_MESSAGE = "statusmessage";

            // response codes of Zaakpay
            /**
             * The constant TRANSACTION_COMPLETED_SUCCESSFULLY.
             */
            public static final String TRANSACTION_COMPLETED_SUCCESSFULLY = "0";
            /**
             * The constant USER_CANCELED_TRANSACTION.
             */
            public static final String USER_CANCELED_TRANSACTION = "43";
        }
    }

    /**
     * The type No resource constants.
     */
    // Constants for Bundle passed to No Resource Fragment
    public static final class NoResourceConstants {

        public static final String TOOLBAR_TITLE = "toolbarTitle";
        /**
         * The constant ICON_TEXT.
         */
        public static final String ICON_TEXT = "iconText";

        public static final String ICON_ID = "iconId";
        /**
         * The constant LARGE_TEXT.
         */
        public static final String LARGE_TEXT = "largeText";
        /**
         * The constant SMALL_TEXT.
         */
        public static final String SMALL_TEXT = "smallText";
        /**
         * The constant BUTTON_TEXT.
         */
        public static final String BUTTON_TEXT = "buttonText";

        /**
         * The constant TAG.
         */
        public static final String TAG = "tag";

    }

    /**
     * This class is used for custom dialog box constants
     */
    public static class DialogConstants {

        /**
         * The constant CHANGE_LOCALITY_DIALOG_BOX.
         */
        public static final String DIALOG_PRIORITY_QUEUE = "dialog_priority_queue";

        public static final String CHANGE_LOCALITY_DIALOG_BOX = "change_locality";

        public static final String NEW_LOC_DETECTED_DIALOG_BOX = "New Location Detected";

        public static final String PLACE_ID_FAILED = "place_id_failed";

        /**
         * The constant UPDATE_APP_1.
         */
        public static final String UPDATE_APP_1 = "update_app_1";
        /**
         * The constant UPDATE_APP_2.
         */
        public static final String UPDATE_APP_2 = "update_app_2";
        /**
         * The constant LOGOUT_DIALOG_BOX.
         */
        public static final String LOGOUT_DIALOG_BOX = "logout_dialog_box";
        /**
         * The constant CALL_US.
         */
        public static final String CALL_US = "call us";
        /**
         * The constant CONFIRM_MISSED_CALL.
         */
        public static final String CONFIRM_MISSED_CALL = "confirm_missed_call";
        /**
         * The constant ID_PICK_LOCALITY.
         */
        public static final int ID_PICK_LOCALITY = 1;

        /**
         * The constant CANCEL_ORDER.
         */
        public static final String CANCEL_ORDER = "cancel_invoice";

        /**
         * The constant CVV_PAYMENT.
         */
        public static final String CVV_PAYMENT = "cvv_payment";

        /**
         * The constant SHOPPING_EXPERIENCE.
         */
        public static final String SHOPPING_EXPERIENCE = "shopping_experience";

        /**
         * The constant SHOPPING_EXPERIENCE.
         */
        public static final String RATE_US = "rate_us";

        /**
         * The constant SHOPPING_EXPERIENCE.
         */
        public static final String FEEDBACK = "feedback";

        /**
         * The constant PAYMENT_FAILURE.
         */
        public static final String PAYMENT_FAILURE = "payment_failure";

        public static final String MIN_ORDER_PROMPT = "min_order_prompt";

        /**
         * The constant SHOPPING_EXPERIENCE.
         */
        public static final String DELIVERY_EXPERIENCE = "delivery_experience";

        /**
         * The constant SHOPPING_EXPERIENCE.
         */
        public static final String DELIVERY_EXPERIENCE_POSITIVE = "delivery_experience_positive";

        /**
         * The constant SHOPPING_EXPERIENCE.
         */
        public static final String DELIVERY_EXPERIENCE_NEGATIVE = "delivery_experience_negative";
        /**
         * The constant DELETE_LEAF_STATE.
         */
        public static final String DELETE_LEAF_STATE = "delete_leaf_state";
        /**
         * The constant DELETE_IMAGE.
         */
        public static final String DELETE_IMAGE_UPLOADED = "delete_image_uploaded";

        public static final String CAMERA_PERMISSION_DENIED = "camera_permission_denied";

        public static final String STORAGE_PERMISSION_DENIED = "storage_permission_denied";

        public static final String STORAGE_CAMERA_PERMISSION_DENIED = "camera_storage_permission_denied";

        public static final String PERMISSION_DENIED = "permission_denied";

        public static final String LAUNCH_PERM_SETTINGS = "launch_permissions_settings";

        public static final String DELETE_CARD_DIALOG = "delete_card_dialog";

        public static final String DIALOG_UPDATE_LOCATION_ON_MAP = "update_location_on_map";
    }


    public static class DialogIds {
        public static final int ID_DIALOG_UPDATE_1 = 2;
        public static final int ID_DIALOG_UPDATE_2 = 3;
        public static final int ID_DIALOG_CHANGE_LOCALITY = 4;
        public static final int ID_NEW_LOC_DETECTED = 5;
        public static final int ID_DIALOG_SHARE = 7;
        public static final int ID_DIALOG_ORDERHISTORY = 8;
        public static final int ID_WEB_LINK = 9;
        public static final int ID_DIALOG_INTERSTITIAL = 10;
        public static final int ID_DIALOG_DEEPLINK_FEEDBACK = 11;
        //public static final int ID_DIALOG_DEMARCATION = 12;
        public static final int ID_DIALOG_BANNER_INFO = 13;
        public static final int ID_DIALOG_CALLUS = 201;
        public static final int ID_DIALOG_LOGOUT = 202;
        public static final int ID_DIALOG_RATE_US = 203;
        public static final int ID_DIALOG_SHOPPING_EXP = 204;
        public static final int ID_DIALOG_FEEDBACK = 205;
        public static final int STORAGE_PERMISSION_DENIED = 206;
        public static final int ID_DIALOG_POST_NEVER_ASK_AGAIN = 207;
        public static final int ID_DIALOG_CARD_CVV = 208;
        public static final int ID_DIALOG_DELETE_CARD = 209;
        public static final int ID_UPDATE_LOCATION_ON_MAP = 210;
    }

    public static class DialogFrequency {
        public static final int FREQ_UNLIMITED = 0;
        public static final int FREQ_ONCE_SESSION = 1;
        public static final int FREQ_NA = 2;
    }

    public class DialogPriority {
        public static final double PRIOR_0 = 0;
        public static final double PRIOR_1_0 = 1;
        public static final double PRIOR_2_0 = 2.0;
        public static final double PRIOR_3_0 = 3.0;
        public static final double PRIOR_4_0 = 4.0;
        //public static final double PRIOR_5_1 = 5.1;
        public static final double PRIOR_5_2 = 5.2;
        public static final double PRIOR_5_3 = 5.3;
        public static final double PRIOR_5_4 = 5.4;
        public static final double PRIOR_5_5 = 5.5;
    }

    public static final String CART_PREFERENCES = "cart_preferences";

    public static final String FACEBOOK_EVENT_CUSTOM_OPENED_CART = "fb_mobile_opened_cart";

    public static final String FACEBOOK_EVENT_CUSTOM_0 = "custom_label_0";

    /**
     * The type Priority.
     */
    public static class Priority {

        /**
         * The interface Priority constants.
         */
        @Retention(RetentionPolicy.SOURCE)
        @IntDef({VERY_LOW, LOW, MEDIUM, HIGH, VERY_HIGH})
        public @interface PriorityConstants {
        }

        /**
         * The constant VERY_LOW.
         */
        public static final int VERY_LOW = 0;
        /**
         * The constant LOW.
         */
        public static final int LOW = 1;
        /**
         * The constant MEDIUM.
         */
        public static final int MEDIUM = 2;
        /**
         * The constant HIGH.
         */
        public static final int HIGH = 3;
        /**
         * The constant VERY_HIGH.
         */
        public static final int VERY_HIGH = 4;
    }

    public class AnimStates {
        public static final int DO_NOTHING = 0;
        public static final int EXPAND = 1;
        public static final int COLLAPSE = 2;
    }


    /**
     * static class, holds merchant group related static final vars
     */
    public static class MerchantGroup {
        public static final String VALUE = "value";
        public static final String EXPRESS = "express";
        public static final String NONE = "none";
    }

    public static class MerchantGroupFacet {
        public static final String ALL = "all";
        public static final String SHOW_ALL_STORE = "show_all_store";
    }








    public static String getStringFromList(List<String> list) {
        String listString = "";
        if (list != null && list.size() > 0) {
            StringBuilder listStringBuilder = new StringBuilder();
            listStringBuilder.append(CommonLib.DELIMITER);
            for (String item : list)
                listStringBuilder.append(item).append(CommonLib.DELIMITER);
            listString = listStringBuilder.toString();
        }
        return listString;
    }

    public static Map<String, String> getMapFromBundle(Bundle bundle) {
        Map<String, String> map = new HashMap<>();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                map.put(key, bundle.getString(key));
            }
        }
        return map;
    }

    public static Map<String, String> getMapFromBundleUsingReflection(Bundle bundle) {
        try {
            Field mapField = bundle.getClass().getSuperclass()
                    .getDeclaredField("mMap");
            mapField.setAccessible(true);
            return (HashMap<String, String>) mapField.get(bundle);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String removeTrailingZeroes(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }





    public static String getIndianCurrencySymbol() {
        String rupee = "\u20b9";
        try {
            byte utf[] = rupee.getBytes("UTF-8");
            rupee = new String(utf, "UTF-8");
            return  rupee;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Rs";
        }


    }

    public static String getIndianFormatCurrency(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("\u20b9");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
        String currencyString = nf.format(amount).replaceAll("\\s+", "");
        return currencyString.substring(0, currencyString.length() - 3);
    }

    public static String getIndianFormatCurrency(long amount) {
        try {
            return getIndianFormatCurrency((double) amount);
        } catch (NumberFormatException e) {
            return getIndianFormatCurrency(0);
        }
    }

    public static String getIndianFormatCurrency(String amount) {
        if (!TextUtils.isEmpty(amount)) {
            try {
                return getIndianFormatCurrency(Double.parseDouble(amount));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return getIndianFormatCurrency(0);
            }
        } else
            return getIndianFormatCurrency(0);
    }


    public static int getStatusBarHeightInPx(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }



    public static String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }


    /**
     * Get Headers for PostMan BulkEdit direct paste
     *
     * @param headers the headers
     * @return headers as string
     */
    public static String getHeadersForBulkEdit(Map<String, String> headers) {
        StringBuilder builder = new StringBuilder();
        for (String key : headers.keySet()) {
            builder.append(key).append(':').append(headers.get(key)).append("\r\n");
        }
        return builder.toString();
    }

    /**
     * Call to show the Product Popup
     *
     * @param context
     * @param productPopupId
     * @return true if product popup is shown, else false
     */



    /**
     * Get phone number
     *
     * @return phone number or empty string.
     */
    private static String getPhoneNumber() {
        String phoneNumber = DBWrapper.get(CommonLib.SharedPrefsKeys.USER_PHONE, null);
        return phoneNumber != null ? phoneNumber : "";
    }

    public static void putString(@NonNull Map<String, String> values, @NonNull String... keys) {
        putDefault(values, CommonLib.DEFAULT, keys);
    }

    public static void putInt(@NonNull Map<String, String> values, @NonNull String... keys) {
        putDefault(values, CommonLib.DEFAULT_INT, keys);
    }


    public static void putDefault(@NonNull Map<String, String> values, String defaultKey, @NonNull String... keys) {
        for (String key : keys) {
            if (!values.containsKey(key)) values.put(key, defaultKey);
        }
    }


    public static boolean compareString(String firstString, String secondString) {
        if (firstString == null && secondString == null)
            return true;
        else if (firstString == null || secondString == null)
            return false;
        else {
            return (firstString.equals(secondString));

        }
    }

    public static boolean compareBoolean(boolean firstBoolean, boolean secondBoolean) {
        return firstBoolean == secondBoolean;
    }

    public static <T> boolean compareObjects(T object1, T object2, Class eventClass) {
        if (object1 == null && object2 == null)
            return true;
        else if (object1 == null || object2 == null)
            return false;
        else {
            if (object1.getClass().getSimpleName() == object2.getClass().getSimpleName()
                    && object1.getClass().getSimpleName().equals(eventClass.getSimpleName())) {
                return ((eventClass.cast(object1)).equals(eventClass.cast(object2)));
            } else {
                return false;
            }
        }
    }


    public static String getStringResourceId(View view) {
        try {
            return view.getResources().getResourceName(view.getId());
        } catch (Resources.NotFoundException e) {
            return view.getClass().getSimpleName();
        }
    }

    public static int daysUntilCurrentDate(long epochTime) {
        Calendar passedDay = getNewCalendarInstance(epochTime * 1000);
        Calendar currentDay = getNewCalendarInstance(System.currentTimeMillis());

        if (passedDay.get(Calendar.YEAR) == currentDay.get(Calendar.YEAR)) {
            return Math.abs(currentDay.get(Calendar.DAY_OF_YEAR) - passedDay.get(Calendar.DAY_OF_YEAR));
        } else {
            if (currentDay.get(Calendar.YEAR) > passedDay.get(Calendar.YEAR)) {
                //swap them
                Calendar temp = passedDay;
                passedDay = currentDay;
                currentDay = temp;
            }
            int extraDays = 0;

            int dayOneOriginalYearDays = passedDay.get(Calendar.DAY_OF_YEAR);

            while (passedDay.get(Calendar.YEAR) > currentDay.get(Calendar.YEAR)) {
                passedDay.add(Calendar.YEAR, -1);
                // getActualMaximum() important for leap years
                extraDays += passedDay.getActualMaximum(Calendar.DAY_OF_YEAR);
            }
            return extraDays - currentDay.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays;
        }
    }

    public static Calendar getNewCalendarInstance(long timeInMillis) {
        Calendar calendarForTime = new GregorianCalendar ();
        calendarForTime.setTimeInMillis(timeInMillis);
        calendarForTime.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        return calendarForTime;
    }

    public static int getObjectHash(Object objectClass) {
        if (objectClass != null) {
            return objectClass.hashCode();
        }
        return -1;
    }

    public static boolean isPackageInstalled(String packageName, Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {

        }

        return false;
    }


    public static String getTooltipKeyFromId(int id) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(CommonLib.SharedPrefsKeys.TOOLTIP_WIDGET);
        keyBuilder.append("_");
        keyBuilder.append(String.valueOf(id));
        return keyBuilder.toString();
    }

    public static boolean isUserVerifiedByServer(Verification verification) {
        return verification.isSuccess() && verification.isVerified();
    }

    public static float getPercentage(float numerator, float denominator) {
        return getPercentage(numerator, denominator, 2);
    }

    public static float getPercentage(float numerator, float denominator, int decimels) {
        int factor = (int) Math.pow(10, decimels);
        return (float) Math.round((numerator * factor / denominator) * factor) / factor;
    }


    public static long getDaysPastSince(long timeStamp) {
        long differenceInMillis = System.currentTimeMillis() - timeStamp;
        return TimeUnit.MILLISECONDS.toDays(differenceInMillis);
    }

}
