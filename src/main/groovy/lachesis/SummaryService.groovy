package lachesis

import javax.inject.Inject

class SummaryService {
    //@Inject
    //SummaryService(CoverageService coverage, TestsService tests) {
    //    this.coverage = coverage
    //    this.tests = tests
    //}

    def summarize() {
        [
            tests: [meanTotal: 250, medianTotal: 300, meanIgnored: 2, medianIgnored: 0, least: 0, leastlink: 'com.netflix/untested', most: 700, mostlink: 'com.netflix/tested'],
            coverage: [],
            timings: [resolve: [mean: 1200, median: 1000, low: 300, lowlink: 'com.netflix/good', high: 4000, highlink: 'com.netflix/bad'],
                    compile: [mean: 5000, median: 5000, low: 2000, lowlink: 'com.netflix/good', high: 10000, highlink: 'com.netflix/bad'],
                    test: [mean: 105000, median: 80000, low: 10000, lowlink: 'com.netflix/good', high: 10800000, highlink: 'com.netflix/bad']]
        ]
    }

    def details(String group, String name) {
        def details
        if (name == 'astrid') {
            details = [ 
                [datetime: 20140801100000, tests: [total: 15, ignored: 1, failed: 0], coverage: [percentage: 80], timing: [resolve: 900, compile: 3000, test: 15000]],
                [datetime: 20140731100000, tests: [total: 14, ignored: 1, failed: 0], coverage: [percentage: 75], timing: [resolve: 900, compile: 2900, test: 14000]],
                [datetime: 20140730100000, tests: [total: 12, ignored: 0, failed: 0], coverage: [percentage: 60], timing: [resolve: 900, compile: 2850, test: 14000]],
                [datetime: 20140729100000, tests: [total: 12, ignored: 0, failed: 3], coverage: [percentage: 60], timing: [resolve: 900, compile: 2870, test: 10000]],
                [datetime: 20140728100000, tests: [total: 10, ignored: 0, failed: 0], coverage: [percentage: 50], timing: [resolve: 900, compile: 3000, test: 12000]]
            ]
        } else {
            details = [
                [datetime: 20140801100000, tests: [total: 150, ignored: 1, failed: 0], coverage: [percentage: 95], timing: [resolve: 2100, compile: 5000, test: 150200]],
                [datetime: 20140731100000, tests: [total: 140, ignored: 10, failed: 0], coverage: [percentage: 75], timing: [resolve: 2200, compile: 2900, test: 140300]],
                [datetime: 20140730100000, tests: [total: 120, ignored: 0, failed: 15], coverage: [percentage: 40], timing: [resolve: 2100, compile: 2850, test: 140100]],
                [datetime: 20140729100000, tests: [total: 120, ignored: 0, failed: 3], coverage: [percentage: 60], timing: [resolve: 2100, compile: 2870, test: 100200]],
                [datetime: 20140728100000, tests: [total: 100, ignored: 0, failed: 0], coverage: [percentage: 50], timing: [resolve: 2200, compile: 3000, test: 120090]]
            ]
        }

        [
            group: group, name: name, details: details, summary: summarize()
        ]
    }
}
