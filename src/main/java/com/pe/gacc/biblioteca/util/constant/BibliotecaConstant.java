package com.pe.gacc.biblioteca.util.constant;

public final class BibliotecaConstant {
    //STATE
    public static final String STATE_ACTIVE     = "1";
    public static final String STATE_DISABLED   = "0";
    //API VERSION
    public static final String API_VERSION = "/v1";
    // =============================================================================================
    // PATH DEL SISTEMA BIBLIOTECA
    // =============================================================================================
    public static final String RESOURCE_GENERIC = API_VERSION + "/api-biblitoteca";
    public static final String RESOURCE_EDITORIALS = "/editorials";
    public static final String RESOURCE_AUTHORS= "/authors";
    public static final String RESOURCE_EDITORIALS_EDITORIAL = "/editorial";
    public static final String RESOURCE_GENERIC_ID= "/{id}";

    public static final String CLIENT_FRONTED = "*";

    // =============================================================================================
    // NOMBRE DE LAS TABLAS
    // =============================================================================================
    public static final String TAB_NAME_AUTHOR = "t_author";
    public static final String TAB_NAME_EDITORIAL = "t_editorial";
    public static final String TAB_NAME_LIBRARY = "t_library";
    public static final String TAB_NAME_AREA = "t_area";
    public static final String TAB_NAME_SUB_AREA = "t_sub_area";
    public static final String TAB_NAME_ZONA = "t_zone";
    public static final String TAB_NAME_BOOK = "t_book";

    // =============================================================================================
    // NOMBRE DE LOS ESQUEMAS
    // =============================================================================================
    public static final String SCHEMA_NAME_DBO = "dbo";

    // =============================================================================================
    // NOMBRE DE LOS PROCEDIMIENTOS ALMACENADOS
    // =============================================================================================
    public static final String SP_SEARCH_AUTHOR = "select * from dbo.fn_search_author(?1,?2)";
    public static final String SP_SEARCH_AUTHOR_COUNT = "select count(*) from dbo.fn_search_author(?1,?2)";
    public static final String SP_SAVE_AUTHOR = "select * from dbo.fn_save_author(?1,?2)";
    public static final String SP_SAVE_AUTHOR_COUNT = "select count(*) from dbo.fn_save_author(?1,?2)";
}
