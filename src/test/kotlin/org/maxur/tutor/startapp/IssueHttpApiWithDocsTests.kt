package org.maxur.tutor.startapp

import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.maxur.tutor.startapp.domain.Issue
import org.maxur.tutor.startapp.domain.IssueRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.hateoas.MediaTypes
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.restdocs.hypermedia.HypermediaDocumentation.*
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs("build/generated-snippets")
class IssueHttpApiWithDocsTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var repository: IssueRepository

    @Test
    @Throws(Exception::class)
    fun createAd() {
        val issue = issue()
        val requestBody = saveRequestJsonString(issue)

        val resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/issues")
                .accept(MediaTypes.HAL_JSON)
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
        )

        resultActions.andExpect(status().isCreated())

        val createdIssue = findCreatedIssue() ?: throw AssertionError()

        resultActions
                .andExpect(header().string(HttpHeaders.LOCATION, "http://localhost:8080/issues/" + createdIssue.id))
                .andExpect(jsonPath("$.id", Matchers.`is`(createdIssue.id)))
                .andExpect(jsonPath("$.name", Matchers.`is`(createdIssue.name)))
                .andExpect(jsonPath("$.description", Matchers.`is`(createdIssue.description)))

        resultActions.andDo(document("create-issue",
                links(halLinks(),
                        linkWithRel("self").description("This issue")
                ),
                responseFields(
                        fieldWithPath("_links").type(JsonFieldType.OBJECT).description("Links"),
                        fieldWithPath("id").type(JsonFieldType.STRING).description("Unique issue id"),
                        fieldWithPath("name").type(JsonFieldType.STRING).description("Issue name"),
                        fieldWithPath("description").type(JsonFieldType.STRING).description("Issue description")
                )))
    }

    private fun findCreatedIssue(): Issue? {
        return repository.findBy("id")
    }

    private fun issue(): Issue {
        return Issue("id", "Issue", "Description")
    }

    private fun saveRequestJsonString(issue: Issue): String = """{
        "id": "${issue.id}",
        "name": "${issue.name}",
        "description": "${issue.description}"
        }"""

}
