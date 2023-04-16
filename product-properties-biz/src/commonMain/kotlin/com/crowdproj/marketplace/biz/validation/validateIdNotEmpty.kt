package com.crowdproj.marketplace.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import com.crowdproj.marketplace.common.PropContext
import com.crowdproj.marketplace.common.helpers.errorValidation
import com.crowdproj.marketplace.common.helpers.fail

fun CorChainDsl<PropContext>.validateIdsNotEmpty(title: String) = worker {
    this.title = title
    on { propsValidating.any { it.id.asString().isEmpty() } }
    handle {
        fail(
            errorValidation(
                field = "ids",
                violationCode = "empty",
                description = "field must not be empty"
            )
        )
    }
}

fun CorChainDsl<PropContext>.validateIdNotEmpty(title: String) = worker {
    this.title = title
    on { propValidating.id.asString().isEmpty() }
    handle {
        fail(
            errorValidation(
                field = "id",
                violationCode = "empty",
                description = "field must not be empty"
            )
        )
    }
}