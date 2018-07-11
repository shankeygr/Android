package com.gotution.app.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.gotution.app.Login;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Api {
    private static final String LOG_TAG = Api.class.getSimpleName ();
    /**
     * Request key
     */
    public static final String REQUEST_KEY_PART1 = "4e9f0f83-";
    public static final String REQUEST_KEY_PART3 = "-9027-";


    /**
     * Get Google places api base address
     *
     * @return a {@link android.net.Uri} which is basically a base address of Google places api
     */
    public static Uri.Builder getGooglePlacesApiBaseAddress() {
        return new Uri.Builder()
                .scheme(GoogleApi.SCHEME_HTTPS)
                .authority(GoogleApi.GOOGLE_MAPS_AUTHORITY)
                .appendPath(GoogleApi.PATH_MAPS)
                .appendPath(GoogleApi.PATH_API);
        //.appendPath(GoogleApi.PATH_PLACE);
    }

    /**
     * @return the {@link android.net.Uri} representing the base address
     */
    public static Uri.Builder getGoTutionBaseAddress() {
        Uri.Builder builder = new Uri.Builder();

        // Build with live authority and scheme when live
        builder.scheme(goTutionApi.SCHEME)
                .authority(goTutionApi.AUTHORITY);

        builder.appendPath(goTutionApi.PATH_VERSION);
        try {
            builder = Uri.parse(java.net.URLDecoder.decode(builder.toString(), "UTF-8")).buildUpon();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return builder;
    }



    /**
     * @return the {@link android.net.Uri} representing the base address
     */
    public static Uri.Builder getGoTutionBaseAddressWithVersion() {
        Uri.Builder builder = new Uri.Builder();

        builder.scheme(goTutionApi.SCHEME)
                .authority(goTutionApi.AUTHORITY);
        builder.appendPath(goTutionApi.VERSION_ONE);
        try {
            builder = Uri.parse(java.net.URLDecoder.decode(builder.toString(), "UTF-8")).buildUpon();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d (LOG_TAG, "Url is:" + builder.toString ());
        return builder;
    }


    /**
     * Get {@link android.net.Uri} of base address with search path
     *
     * @return {@link android.net.Uri} of base address appending search path
     */
    public static Uri.Builder getBaseAddressWithSearch() {
        return getGoTutionBaseAddress().appendPath(goTutionApi.PATH_SEARCH);
    }

    public static Uri.Builder getBaseAddressV3WithSearch() {
        return getGoTutionBaseAddressWithVersion().appendPath(goTutionApi.PATH_SEARCH);
    }




    /**
     * Return Accounts {@link Uri}
     *
     * @return Accounts accounts uri
     */
    public static Uri getAccountsUri() {
        return getGoTutionBaseAddress().appendPath(AccountsApi.PATH_ACCOUNTS).build();
    }


    /**
     * Get a {@link Uri} to send GCM registration key server
     *
     * @return a for sending GCM key to server
     */
    public static Uri getPushNotificationUri() {
        return getGoTutionBaseAddress()
                .appendPath(goTutionApi.PATH_PUSH_NOTIFICATION)
                /*.appendPath(GrofersApi.PATH_SAVE_DEVICE_INFO)*/.build();
    }


    /**
     * Constant used for Api
     */
    public static class goTutionApi {

        public static final String SCHEME_APP = "android-app";
        public static final String SCHEME_HTTPS = "http";

        public static final String API_STAGE = "api-consumer-stage.grofer.io";
        private static final String API_LIVE_H2 = "expapiconsumer.grofers.com";
        private static final String API_PRE_2 = "preprodapi2.grofers.com";
        private static final String API_LIVE = "api.grofers.com";
        private static final String API_LIVE_HTTP2 = "27abbe99.ngrok.io";

        public static final HashSet<String> STAGE_API_OPTION_SET = new HashSet<>(Arrays.asList(API_STAGE));
        public static final HashSet<String> PROD_API_OPTION_SET = new HashSet<>(Arrays.asList(API_LIVE_H2, API_PRE_2, API_LIVE, API_LIVE_HTTP2));

        public static final String VERSION_ONE = "v1";
        public static final String VERSION_TWO = "v2";
        public static final String VERSION_THREE = "v3";
        public static final String VERSION_FOUR = "v4";
        public static final String VERSION_FIVE = "v5";

        public static final String CDN_BASE_URL = "http://cdn.grofers.com/app/images";

        public static final String QUERY_PARAM_ORDER_ID = "order_id";

        /**
         * The constant PATH_VERSION.
         */
        public static String PATH_VERSION = VERSION_ONE;
        /**
         * The constant AUTHORITY.
         */
        public static String AUTHORITY = API_LIVE_HTTP2;           // Actual URL that will be used to fetch data

        public static final String MICROMAX_PRELOADED_ATTRIBUTION_TRACKING_TAG = "http://ad.apsalar.com/api/v1/ad?re=1&st=311462936704&h=5dc593e6bf7338495d7a8d793d8b42ee1bde8331";

        public static final boolean IS_PRELOADED_APK = false;

        /**
         * The constant SCHEME.
         */
        public static String SCHEME = SCHEME_HTTPS;

        public static String MAPS_BASE_URL = "https://maps.googleapis.com";

        public static final String SCHEME_GROFERS = "grofers";

        public static final String AUTHORITY_MERCHANT = "merchant";
        /**
         * The constant QUERY_PARAM_LATITUDE.
         */
        public static final String QUERY_PARAM_LATITUDE = "lat";             // MerchantSearch's Store Location
        /**
         * The constant QUERY_PARAM_LONGITUDE.
         */
        public static final String QUERY_PARAM_LONGITUDE = "lon";

        public static final String QUERY_PARAM_SUGGESTION_TYPE = "suggestion_type";

        public static final String QUERY_PARAM_SHOW = "show";

        public static final String TARGET = "target";
        /**
         * The constant QUERY_PARAM_START.
         */
        public static final String QUERY_PARAM_START = "start";              // start index of resultsc

        public static final String QUERY_PARAM_SIZE = "size";
        /**
         * The constant QUERY_PARAM_NEXT.
         */
        public static final String QUERY_PARAM_NEXT = "next";                // numbers for results to be fetched from server
        /**
         * The constant QUERY_PARAM_APP_VERSION.
         */
        public static final String QUERY_PARAM_APP_VERSION = "consumer_app_android_version";
        /**
         * The constant QUERY_PARAM_QUERY.
         */
        public static final String QUERY_PARAM_QUERY = "q";
        /**
         * The constant QUERY_REQUEST_CODE.
         */
        public static final String QUERY_REQUEST_CODE = "request_code";
        /**
         * The constant QUERY_PARAM_CATEGORY.
         */
        public static final String QUERY_PARAM_CATEGORY = "cat";
        /**
         * The constant QUERY_PARAM_LOCALITY.
         */
        public static final String QUERY_PARAM_LOCALITY = "loc_text";
        /**
         * The constant QUERY_PARAM_CITY.
         */
        public static final String QUERY_PARAM_CITY = "city";

        public static final String QUERY_PARAM_FILTER = "filter";

        public static final String QUERY_PARAM_STORE_LAYOUT_TYPE = "merchant_layout_type";

        public static final String QUERY_PARAM_STORE_SELF_LINK = "self_link";

        public static final String QUERY_PARAM_STORE_SELECTION = "store_selection";

        public static final String QUERY_TEMPLATE_VERSION = "template_version";

        /**
         * The constant IS_FIRST_LAUNCH.
         */
        public static final String IS_FIRST_LAUNCH = "is_first_launch";

        /**
         * The constant QUERY_PARAM_USER_ID.
         */
        public static final String QUERY_PARAM_USER_ID = "user_id";
        /**
         * The constant QUERY_PARAM_ADV_ID.
         */
        public static final String QUERY_PARAM_ADV_ID = "adv_id";

        /**
         * The constant QUERY_PARAM_TIMESTAMP.
         */
        public static final String QUERY_PARAM_TIMESTAMP = "t";
        /**
         * The constant QUERY_PARAM_PROVIDER.
         */
        public static final String QUERY_PARAM_PROVIDER = "provider";

        public static final String QUERY_PAYABLE_AMOUNT = "amount";

        public static final String QUERY_PARAM_LAST_VISIT = "offers_last_visit_ts";

        public static final String IS_LOCATION_CHANGED = "location_changed";
        /**
         * The constant QUERY_PARAM_REGISTRATION_ID.
         */
        public static final String QUERY_PARAM_REGISTRATION_ID = "registration_id";
        /**
         * The constant QUERY_PARAM_NOTIFICATIONS_TIMESTAMP.
         */
        public static final String QUERY_PARAM_NOTIFICATIONS_TIMESTAMP = "timestamp";
        /**
         * The constant PATH_ADDRESSES.
         */
        public static final String PATH_ADDRESSES = "address";
        /**
         * The constant PATH_EDIT.
         */
        public static final String PATH_EDIT = "edit";
        /**
         * The constant PATH_SERVICE_UPDATE.
         */
        public static final String PATH_SERVICE_UPDATE = "services/consumerappupdate/";

        public static final String PATH_SECONDARY_DATA = "services/secondary-data/";
        /**
         * The constant PATH_EMAIL.
         */
        public static final String PATH_EMAIL = "email";
        /**
         * The constant CART_ADDRESS.
         */
        public static final String CART_ADDRESS = "cart";

        /**
         * The constant WALLET
         */
        public static final String WALLET = "wallet";

        /**
         * The constant PATH_AUTH.
         */
        public static final String PATH_AUTH = "auth_key";
        /**
         * The constant PATH_SEARCH.
         */
        public static final String PATH_SEARCH = "search";

        public static final String PATH_RECOMMENDATIONS = "recommendations";

        public static final String PATH_SEARCH_WIDGET = "new_search/";
        /**
         * The constant PATH_MERCHANTS.
         */
        public static final String PATH_MERCHANTS = "merchants";      // sub path where we fetch stores list

        public static final String PATH_NEW_SEARCH = "new_search";      // sub path where we fetch stores list

        /**
         * The constant PATH_MERCHANTS_ID.
         */
        public static final String PATH_MERCHANT_ID = "merchant_id";
        /**
         * The constant PATH_PUSH_NOTIFICATION.
         */
        public static final String PATH_PUSH_NOTIFICATION = "push_notifications";

        public static final String PATH_OFFERS = "offers";
        /**
         * The constant PATH_NOTIFICATIONS.
         */
        public static final String PATH_NOTIFICATIONS = "notifications";

        public static final String PATH_SAVE_DEVICE_INFO = "save_device_info/";
        /**
         * The constant PATH_CATEGORIES.
         */
        public static final String PATH_CATEGORIES = "categories";
        /**
         * The constant PATH_ALL.
         */
        public static final String PATH_ALL = "all";
        /**
         * The constant PATH_LOGIN.
         */
        public static final String PATH_LOGIN = "login";
        /**
         * The constant PATH_LOGOUT.
         */
        public static final String PATH_LOGOUT = "logout/";
        /**
         * The constant PATH_FACEBOOK.
         */
        public static final String PATH_FACEBOOK = "facebook";
        /**
         * The constant PATH_FAQS.
         */
        public static final String PATH_FAQS = "faqs";

        public static final String PATH_DEEPLINK = "deeplink/";

        public static final String PATH_ENDPOINT = "endpoint";

        /**
         * The constant JSON_KEY_LATITUDE.
         */
        public static final String JSON_KEY_LATITUDE = "lat";
        /**
         * The constant JSON_KEY_LONGITUDE.
         */
        public static final String JSON_KEY_LONGITUDE = "lon";
        /**
         * The constant QUERY_PARAM_CAT_ID.
         */
        public static final String QUERY_PARAM_VERSION = "version";

        public static final String QUERY_PARAM_FEED_VERSION = "template_version";

        public static final String QUERY_PARAM_CAT_ID = "category_id";

        public static final String QUERY_PARAM_C_ID = "c_id";

        public static final String QUERY_COLLECTION_ID = "collection_id";

        public static final String QUERY_PARAM_CAT_TYPE = "category_type";
        /**
         * The constant PATH_USER_DETAILS.
         */
        public static final String PATH_USER_DETAILS = "user_details";
        public static final String PATH_SERVICE = "services";
        public static final String PLACES_API_KEY = "apikey";

        public static final String PATH_FEED = "feed/";
        public static final String QUERY_PARAM_PAGE = "page";
        public static final String QUERY_PARAM_CITY_NAME = "city_name";

        public static final String QUERY_SUB_CAT = "cid";
        public static final String QUERY_MER = "mid";
        public static final String QUERY_SELLER_ID = "sids";
        public static final String QUERY_RESTRICTED_MERCHANT = "restricted";
        public static final String QUERY_SUB_CATS = "cids";
        public static final String QUERY_EXPRESSION = "expr";
        public static final String QUERY_MER_C = "chain_id";
        public static final String QUERY_PRO = "pid";
        public static final String QUERY_PRODUCTS = "pids";

        public static final String QUERY_PARAM_TYPE = "type";
        public static final String QUERY_PARAM_TYPE_ID = "type_id";
        public static final String QUERY_PARAM_ADDRESS_ID = "address_id";
        public static final String QUERY_PARAM_CAPACITY_TYPE = "capacity_type";

        public static final String LAST_CHAT_TIMESTAMP = "last_chat_timestamp";

        /**
         * The type Tracking api.
         */
        public static class TrackingApi {
            /**
             * The constant PATH_TRACK.
             */
            public static final String PATH_TRACK = "track";
            /**
             * The constant PATH_PUSH_NOTIFICATION.
             */
            public static final String PATH_PUSH_NOTIFICATION = "push_notifications";
        }

        public static boolean isLive() {
            if (AUTHORITY.equals(API_LIVE) || AUTHORITY.equals(API_LIVE_HTTP2))
                return true;
            return false;
        }
    }

    /**
     * Constants used for Accounts api
     */
    public static class AccountsApi {
        /**
         * The constant PATH_ACCOUNTS.
         */
        public static final String PATH_ACCOUNTS = "accounts";
        /**
         * The constant USER_PHONE.
         */
        public static final String USER_PHONE = "phone";
        public static final String USER_TYPE = "login_type";
        /**
         * The constant QUERY_PARAM_VERIFY_CODE.
         */
        public static final String QUERY_PARAM_VERIFY_CODE = "verify_code";
        /**
         * The constant PHONE.
         */
        public static final String PHONE = "phone";

        public static final String USER = "user";
    }

    /**
     * <p> Google apis</p>
     */
    public static class GoogleApi {
        /**
         * The constant DEFAULT_RADIUS.
         */
        public static final String DEFAULT_RADIUS = "100000";
        /**
         * The constant DEFAULT_LANGUAGE.
         */
        public static final String DEFAULT_LANGUAGE = "en";

        /**
         * The constant SCHEME_HTTPS.
         */
        public static final String SCHEME_HTTPS = "https";

        /**
         * The constant GOOGLE_MAPS_AUTHORITY.
         */
        public static final String GOOGLE_MAPS_AUTHORITY = "maps.googleapis.com";
        /**
         * The constant PATH_MAPS.
         */
        public static final String PATH_MAPS = "maps";
        /**
         * The constant PATH_API.
         */
        public static final String PATH_API = "api";
        /**
         * The constant PATH_PLACE.
         */
        public static final String PATH_PLACE = "place";
        /**
         * The constant PATH_QUERYAUTOCOMPLETE.
         */
        public static final String PATH_QUERYAUTOCOMPLETE = "autocomplete";

        public static final String PATH_DETAILS = "details";
        /**
         * The constant RESULT_TYPE_JSON.
         */
        public static final String RESULT_TYPE_JSON = "json";
        /**
         * The constant KEY.
         */
        public static final String KEY = "key";
        /**
         * The constant PLACE_ID.
         */
        public static final String PLACE_ID = "placeid";
        /**
         * The constant LANGUAGE.
         */
        public static final String LANGUAGE = "language";

        public static final String LOCATION = "location";

        public static final String COMPONENTS = "components";
        /**
         * The constant RADIUS.
         */
        public static final String RADIUS = "radius";
        /**
         * The constant INPUT.
         */
        public static final String INPUT = "input";

        /**
         * The type Places auto complete.
         */
        public static class PlacesAutoComplete {
            /**
             * The constant PREDICTIONS.
             */
            public static final String PREDICTIONS = "predictions";
            /**
             * The constant STATUS.
             */
            public static final String STATUS = "status";
            /**
             * The constant DESCRIPTION.
             */
            public static final String DESCRIPTION = "description";
            /**
             * The constant PLACE_ID.
             */
            public static final String PLACE_ID = "place_id";

            /**
             * The constant TYPES
             */
            public static final String TYPES = "types";

            /**
             * The constant RESULT_OK.
             */
            public static final String RESULT_OK = "OK";
            /**
             * The constant ZERO_RESULTS.
             */
            public static final String ZERO_RESULTS = "ZERO_RESULTS";

            public static final String NOT_FOUND = "NOT_FOUND";
            /**
             * The constant OVER_QUERY_LIMIT.
             */
            public static final String OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
            /**
             * The constant REQUEST_DENIED.
             */
            public static final String REQUEST_DENIED = "REQUEST_DENIED";
            /**
             * The constant INVALID_REQUEST.
             */
            public static final String INVALID_REQUEST = "INVALID_REQUEST";
        }
    }

    /**
     * Constants used for campaign api's
     */
    public static class DialogPopUp {
        /**
         * The constant PATH_CAMPAIGN.
         */
        public static final String PATH_CAMPAIGN = "campaign/";
        /**
         * The constant PATH_POPUPS.
         */
        public static final String PATH_POPUPS = "popups/";

    }

    /**
     * Constants used for phone verification api
     */
    public static class PhoneVerification {
        /**
         * The constant PATH_VERIFY.
         */
        public static final String PATH_VERIFY = "verify";
        /**
         * The constant PATH_PHONE.
         */
        public static final String PATH_PHONE = "phone";
        /**
         * The constant PATH_CODE.
         */
        public static final String PATH_CODE = "code";
        /**
         * The constant PATH_CODE.
         */
        public static final String PATH_STATUS = "status";
        /**
         * The constant ID.
         */
        public static final int ID = 99;

        public static final int ID_FOR_CHECKOUT = 100;
    }

}
