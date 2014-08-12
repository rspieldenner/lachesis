import ratpack.jackson.JacksonModule
import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

ratpack {
  bindings {
    add new JacksonModule()
  }
  handlers {
    get {
      render groovyTemplate('index.html', title: 'My Ratpack App')
    }
    get('robjson') {
      render json(user: 1)
    }
        
    assets 'public'
  }
}
