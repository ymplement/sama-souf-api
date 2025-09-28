package com.samasouf.domain.chat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import com.samasouf.domain.Announcement;
import com.samasouf.domain.User;

@Setter
@Getter
@Entity
@Table(name = "message")
@Audited
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    private Long message_id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "user_id")
    private User recipient;

    @ManyToOne
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id")
    private Announcement announcement;

    @Column(length = 4000, name = "content")
    private String content;

    @Column(name = "sent_at")
    private OffsetDateTime sent_at;

    @Column(name = "read_at")
    private LocalDateTime read_at;

    @Column(name = "is_read")
    private boolean isRead;

    @Column(name = "author_deleted")
    private boolean authorDeleted;

    @Column(name = "recipient_deleted")
    private boolean recipientDeleted;

}
