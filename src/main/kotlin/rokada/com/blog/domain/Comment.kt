package rokada.com.blog.domain

import java.time.LocalDateTime

data class Comment(val id: String?,
                   val text: String,
                   val commentBy: String,
                   val commentDate: LocalDateTime = LocalDateTime.now())