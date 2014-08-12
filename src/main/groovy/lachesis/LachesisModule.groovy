package lachesis

import com.google.inject.AbstractModule

class LachesisModule extends AbstractModule {

  final URL resource

  LachesisModule(URL resource) {
    this.resource = resource
  }

  @Override
  protected void configure() {
    bind(TestsService).toInstance(new TestsService())
    bind(CoverageService).toInstance(new CoverageService())
    bind(SummaryService).toInstance(new SummaryService())
  }
}
