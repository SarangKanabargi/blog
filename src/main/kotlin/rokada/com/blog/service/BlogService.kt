package rokada.com.blog.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import rokada.com.blog.domain.Blog
import rokada.com.blog.repository.BlogRepository

@Service
class BlogService(val blogRepository: BlogRepository) {

    fun addBlog(blog: Blog): Mono<Blog> =
            blogRepository.save(blog)

    fun getBlogs(): Flux<Blog> =
            blogRepository.findAll()


    fun getBlog(blogId: String): Mono<Blog> =
            blogRepository.findById(blogId)

}