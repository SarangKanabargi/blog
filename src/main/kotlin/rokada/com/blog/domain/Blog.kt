package rokada.com.blog.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Blog(@Id val id: String?,
                val title: String,
                val data: String,
                val createdBy: String,
                val createdDate: LocalDateTime = LocalDateTime.now())