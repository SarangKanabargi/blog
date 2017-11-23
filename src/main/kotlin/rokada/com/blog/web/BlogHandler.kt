package rokada.com.blog.web

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import rokada.com.blog.domain.Blog
import rokada.com.blog.service.BlogService

@Component
class BlogHandler(val blogService: BlogService) {

    fun getBlog(req: ServerRequest): Mono<ServerResponse> {
        val blog = blogService.getBlog(req.pathVariable("blogId"))
        return ServerResponse.ok()
                .body(blog)
    }

    fun getBlogs(req: ServerRequest): Mono<ServerResponse> {
        val blogs = blogService.getBlogs()
        return ServerResponse.ok()
                .body(blogs)
    }

    fun addBlog(req: ServerRequest): Mono<ServerResponse> {

        val blogMono = req.bodyToMono(Blog::class.java)
        blogMono.flatMap {
            val blog = Blog(it.id, it.title, it.data, it.createdBy, it.createdDate)
            blogService.addBlog(blog)
        }.subscribe({ println(it) })
        println("Successfully added data to MongoDB.. ")
        return ServerResponse.ok()
                .body(Mono.just("Added! "))

    }
}