var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3",
        "ok": "3",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "409",
        "ok": "409",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "145",
        "ok": "145",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "186",
        "ok": "186",
        "ko": "-"
    },
    "percentiles1": {
        "total": "15",
        "ok": "15",
        "ko": "-"
    },
    "percentiles2": {
        "total": "212",
        "ok": "212",
        "ko": "-"
    },
    "percentiles3": {
        "total": "370",
        "ok": "370",
        "ko": "-"
    },
    "percentiles4": {
        "total": "401",
        "ok": "401",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.273",
        "ok": "0.273",
        "ko": "-"
    }
},
contents: {
"req_get-all-games---b12bf": {
        type: "REQUEST",
        name: "Get All Games- 1st call",
path: "Get All Games- 1st call",
pathFormatted: "req_get-all-games---b12bf",
stats: {
    "name": "Get All Games- 1st call",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "15",
        "ok": "15",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "409",
        "ok": "409",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "212",
        "ok": "212",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "197",
        "ok": "197",
        "ko": "-"
    },
    "percentiles1": {
        "total": "212",
        "ok": "212",
        "ko": "-"
    },
    "percentiles2": {
        "total": "311",
        "ok": "311",
        "ko": "-"
    },
    "percentiles3": {
        "total": "389",
        "ok": "389",
        "ko": "-"
    },
    "percentiles4": {
        "total": "405",
        "ok": "405",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 2,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.182",
        "ok": "0.182",
        "ko": "-"
    }
}
    },"req_get-specific-ga-f2d93": {
        type: "REQUEST",
        name: "Get Specific Game",
path: "Get Specific Game",
pathFormatted: "req_get-specific-ga-f2d93",
stats: {
    "name": "Get Specific Game",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles2": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles3": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles4": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.091",
        "ok": "0.091",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
