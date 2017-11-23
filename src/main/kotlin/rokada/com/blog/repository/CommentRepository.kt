package rokada.com.blog.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import rokada.com.blog.domain.Comment

@Repository
interface CommentRepository : ReactiveMongoRepository<Comment, String>