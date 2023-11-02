package com.woowahan.campus.fixture

import com.woowahan.campus.announcement.domain.Announcement
import openapi.model.AnnouncementInfoResponse
import openapi.model.AnnouncementsInfoByOffsetResponse
import java.time.LocalDateTime

fun createAnnouncement(
    title: String,
    content: String,
    author: String,
    slackChannelId: Int,
    createdAt: LocalDateTime = LocalDateTime.now(),
    id: Long = 0L,
): Announcement {
    return Announcement(title, content, author, slackChannelId, createdAt, id)
}

fun createAnnouncementsInfoByOffsetResponse(
    announcements: List<Announcement>,
    page: Int,
    size: Int,
    totalElements: Int,
    totalPages: Int,
): AnnouncementsInfoByOffsetResponse {
    return AnnouncementsInfoByOffsetResponse(
        announcements.map { createAnnouncementInfoResponse(it) },
        page,
        size,
        totalElements,
        totalPages
    )
}

fun createAnnouncementInfoResponse(announcement: Announcement): AnnouncementInfoResponse {
    return AnnouncementInfoResponse(
        announcement.id.toInt(),
        announcement.title,
        announcement.author,
        announcement.createdAt.toString()
    )
}