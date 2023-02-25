package com.bolton.patpat.constant;

public class NativeQueries {

    public static final String FILTER_VEHICLE_QUERY = "SELECT *\n" +
            "FROM vehicle v\n" +
            "WHERE (?1 IS NULL OR v.model LIKE %?1%)\n" +
            "  AND (?2 IS NULL OR v.title LIKE %?2%)\n" +
            "  AND (?3 IS NULL OR v.brand LIKE %?3%)\n" +
            "  AND (?4 IS NULL OR v.description LIKE %?4%)\n" +
            "  AND (?5 IS NULL OR v.location LIKE %?5%)\n" +
            "  AND (?6 IS NULL OR v.used_type LIKE %?6%)\n" +
            "  AND (?7 IS NULL OR v.fuel_type LIKE %?7%)\n" +
            "  AND (?8 IS NULL OR v.model_year LIKE %?8%)\n" +
            "  AND website = ?9\n" +
            "ORDER BY v.ad_id DESC";

    public static final String FILTER_VEHICLE_COUNT_QUERY = "SELECT COUNT(v.ad_id)\n" +
            "FROM vehicle v\n" +
            "WHERE (?1 IS NULL OR v.model LIKE %?1%)\n" +
            "  AND (?2 IS NULL OR v.title LIKE %?2%)\n" +
            "  AND (?3 IS NULL OR v.brand LIKE %?3%)\n" +
            "  AND (?4 IS NULL OR v.description LIKE %?4%)\n" +
            "  AND (?5 IS NULL OR v.location LIKE %?5%)\n" +
            "  AND (?6 IS NULL OR v.used_type LIKE %?6%)\n" +
            "  AND (?7 IS NULL OR v.fuel_type LIKE %?7%)\n" +
            "  AND (?8 IS NULL OR v.model_year LIKE %?8%)\n" +
            "  AND website = ?9\n" +
            "ORDER BY v.ad_id DESC";
}
