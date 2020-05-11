package by.gvu.jd2.ishop.bean.define;

public class Define {
    public static final String COMMAND = "COMMAND";
    public static final String COMMAND_REGISTRATION = "REGISTRATION";
    public static final String COMMAND_LOGIN = "LOGIN";

    public static final String VERIFY_REGISTRATION = "/REGISTRATION_VERIFY";
    public static final String VERIFY_LOGIN = "/LOGIN_VERIFY";

    public static final String MAIN_PAGE = "MainPage";
    public static final String REGISTRATION_PAGE = "Registration";
    public static final String LOGIN_PAGE = "/LOGIN";

    public static final String BEAN_USER_ID = "ID";
    public static final String BEAN_USER_LOGIN = "LOGIN";
    public static final String BEAN_USER_PSW_MD5 = "PSW_MD5";
    public static final String BEAN_USER_PSW_SHA3 = "PSW_SHA3";
    public static final String BEAN_USER_EMAIL = "EMAIL";
    public static final String BEAN_USER_ROLE = "ROLE";
    public static final String BEAN_USER_FIRST_NAME = "FIRST_NAME";
    public static final String BEAN_USER_SECOND_NAME = "SECOND_NAME";
    public static final String BEAN_USER_NIK_NAME = "NIK_NAME";
    public static final String BEAN_USER_SEX = "SEX";
    public static final String BEAN_USER_BIRTHDAY = "BIRTHDAY";

    public static final String WEB_USER_ID = "ID";
    public static final String WEB_USER_LOGIN = "LOGIN";
    public static final String WEB_USER_PASSWORD = "PASSWORD";
    public static final String WEB_USER_PASSWORD_CONFIRM = "PASSWORD_CONFIRM";
    public static final String WEB_USER_EMAIL = "EMAIL";
    public static final String WEB_USER_ROLE = "ROLE";
    public static final String WEB_USER_FIRST_NAME = "FIRST_NAME";
    public static final String WEB_USER_SECOND_NAME = "SECOND_NAME";
    public static final String WEB_USER_NIK_NAME = "NIK_NAME";
    public static final String WEB_USER_SEX = "SEX";
    public static final String WEB_USER_BIRTHDAY = "BIRTHDAY";

    public static final String CURRENT_USER = "CURRENT_USER";
    public static final String ERROR_MESSAGE = "ERROR_MESSAGE";

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static final String SQL_USER_ADD = "INSERT INTO ISHOP.USERS (LOGIN, PSW_SHA3, PSW_MD5, EMAIL, ROLE, FIRST_NAME, SECOND_NAME, NIK_NAME, SEX, BIRTHDAY) VALUES (?,?,?,?,?,?,?,?,?,?)";
    public static final String SQL_USER_GET_BY_LOGIN = "SELECT ID, LOGIN, PSW_SHA3, PSW_MD5, EMAIL, ROLE, FIRST_NAME, SECOND_NAME, NIK_NAME, SEX, BIRTHDAY FROM ISHOP.USERS WHERE LOGIN=?";
    public static final String SQL_USER_GET_BY_ID = "SELECT ID, LOGIN, PSW_SHA3, PSW_MD5, EMAIL, ROLE, FIRST_NAME, SECOND_NAME, NIK_NAME, SEX, BIRTHDAY FROM ISHOP.USERS WHERE ID=?";
}

