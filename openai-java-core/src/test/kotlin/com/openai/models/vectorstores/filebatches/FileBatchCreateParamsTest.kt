// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.FileChunkingStrategyParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchCreateParamsTest {

    @Test
    fun create() {
        FileBatchCreateParams.builder()
            .vectorStoreId("vs_abc123")
            .addFileId("string")
            .attributes(
                FileBatchCreateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FileBatchCreateParams.builder().vectorStoreId("vs_abc123").addFileId("string").build()

        assertThat(params._pathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FileBatchCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .addFileId("string")
                .attributes(
                    FileBatchCreateParams.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .build()

        val body = params._body()

        assertThat(body.fileIds()).containsExactly("string")
        assertThat(body.attributes())
            .contains(
                FileBatchCreateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileBatchCreateParams.builder().vectorStoreId("vs_abc123").addFileId("string").build()

        val body = params._body()

        assertThat(body.fileIds()).containsExactly("string")
    }
}
