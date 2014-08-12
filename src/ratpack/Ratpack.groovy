import lachesis.CoverageService
import lachesis.LachesisModule
import lachesis.SummaryService
import lachesis.TestsService
import ratpack.jackson.JacksonModule
import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

ratpack {
  bindings {
    add new JacksonModule()
    add new LachesisModule()
  }
  handlers {
    get {
      render groovyTemplate('index.html', title: 'Lachesis Build Metrics')
    }
    get('summary') { SummaryService summarizer ->
      render json(summarizer.summarize())
    }
    get(':group/:name') { SummaryService summarizer ->
      render json(summarizer.details(pathTokens['group'], pathTokens['name']))
    }
    prefix('tests') { TestsService tests ->
      get(':group/:name') {
        render json(group: pathTokens['group'], name: pathTokens['name'], total: 15, passed: 14, failed: 0, ignored: 1, time: 105000)
      }
    }
    prefix('coverage') { CoverageService coverage ->
      get(':group/:name') {
        render json(group: pathTokens['group'], name: pathTokens['name'], coveredPercentage: 85, meanPercentage: 60, medianPercentage: 70, link: 'http://builds.netflix.com/jobs/example')
      }
    }
        
    assets 'public'
  }
}
