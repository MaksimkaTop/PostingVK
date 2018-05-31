package com.example.maks.postingvk.entity

import com.google.gson.annotations.SerializedName


data class DataGroup(
        @SerializedName("response") var response: Response
) {
    data class Response(
            @SerializedName("count") var count: Int,
            @SerializedName("items") var items: List<Item>
    ) {
        data class Item(
                @SerializedName("id") var id: Int,
                @SerializedName("from_id") var fromId: Int,
                @SerializedName("owner_id") var ownerId: Int,
                @SerializedName("date") var date: Int,
                @SerializedName("marked_as_ads") var markedAsAds: Int,
                @SerializedName("post_type") var postType: String,
                @SerializedName("text") var text: String,
                @SerializedName("is_pinned") var isPinned: Int,
                @SerializedName("attachments") var attachments: List<Attachment>,
                @SerializedName("post_source") var postSource: PostSource,
                @SerializedName("comments") var comments: Comments,
                @SerializedName("likes") var likes: Likes,
                @SerializedName("reposts") var reposts: Reposts,
                @SerializedName("views") var views: Views
        ) {
            data class Attachment(
                    @SerializedName("type") var type: String,
                    @SerializedName("photo") var photo: Photo,
                    @SerializedName("link") var link: Link
            ) {
                data class Link(
                        @SerializedName("url") var url: String,
                        @SerializedName("title") var title: String,
                        @SerializedName("description") var description: String,
                        @SerializedName("target") var target: String,
                        @SerializedName("photo") var photo: Photo
                ) {
                    data class Photo(
                            @SerializedName("id") var id: Int,
                            @SerializedName("album_id") var albumId: Int,
                            @SerializedName("owner_id") var ownerId: Int,
                            @SerializedName("sizes") var sizes: List<Size>,
                            @SerializedName("text") var text: String,
                            @SerializedName("date") var date: Int
                    ) {
                        data class Size(
                                @SerializedName("type") var type: String,
                                @SerializedName("url") var url: String,
                                @SerializedName("width") var width: Int,
                                @SerializedName("height") var height: Int
                        )
                    }
                }

                data class Photo(
                        @SerializedName("id") var id: Int,
                        @SerializedName("album_id") var albumId: Int,
                        @SerializedName("owner_id") var ownerId: Int,
                        @SerializedName("user_id") var userId: Int,
                        @SerializedName("sizes") var sizes: List<Size>,
                        @SerializedName("text") var text: String,
                        @SerializedName("date") var date: Int,
                        @SerializedName("access_key") var accessKey: String
                ) {
                    data class Size(
                            @SerializedName("type") var type: String,
                            @SerializedName("url") var url: String,
                            @SerializedName("width") var width: Int,
                            @SerializedName("height") var height: Int
                    )
                }
            }

            data class Comments(
                    @SerializedName("count") var count: Int,
                    @SerializedName("groups_can_post") var groupsCanPost: Boolean,
                    @SerializedName("can_post") var canPost: Int
            )

            data class PostSource(
                    @SerializedName("type") var type: String
            )

            data class Views(
                    @SerializedName("count") var count: Int
            )

            data class Likes(
                    @SerializedName("count") var count: Int,
                    @SerializedName("user_likes") var userLikes: Int,
                    @SerializedName("can_like") var canLike: Int,
                    @SerializedName("can_publish") var canPublish: Int
            )

            data class Reposts(
                    @SerializedName("count") var count: Int,
                    @SerializedName("user_reposted") var userReposted: Int
            )
        }
    }
}