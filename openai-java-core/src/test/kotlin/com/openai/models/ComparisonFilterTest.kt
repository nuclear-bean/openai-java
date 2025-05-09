// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComparisonFilterTest {

    @Test
    fun create() {
        val comparisonFilter =
            ComparisonFilter.builder()
                .key("key")
                .type(ComparisonFilter.Type.EQ)
                .value("string")
                .build()

        assertThat(comparisonFilter.key()).isEqualTo("key")
        assertThat(comparisonFilter.type()).isEqualTo(ComparisonFilter.Type.EQ)
        assertThat(comparisonFilter.value()).isEqualTo(ComparisonFilter.Value.ofString("string"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val comparisonFilter =
            ComparisonFilter.builder()
                .key("key")
                .type(ComparisonFilter.Type.EQ)
                .value("string")
                .build()

        val roundtrippedComparisonFilter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(comparisonFilter),
                jacksonTypeRef<ComparisonFilter>(),
            )

        assertThat(roundtrippedComparisonFilter).isEqualTo(comparisonFilter)
    }
}
