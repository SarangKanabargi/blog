package rokada.com.blog.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiRoutes(val blogHandler: BlogHandler) {

    @Bean
    fun apiRouter() = router {
        (accept(APPLICATION_JSON) and "/api").nest {
            "/blog".nest {
                GET("/", blogHandler::getBlogs)
                GET("/{blogId}", blogHandler::getBlog)
                POST("/", blogHandler::addBlog)
            }
        }
    }
}