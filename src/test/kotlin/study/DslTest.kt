package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * introduce {
 *   name("홍길동")
 *   company("활빈당")
 *   skills {
 *     soft("A passion for problem solving")
 *     soft("Good communication skills")
 *     hard("Kotlin")
 *   }
 *   languages {
 *     "Korean" level 5
 *     "English" level 3
 *   }
 * }
 */
class DslTest {
    @ValueSource(strings = ["홍길동", "Albert"])
    @ParameterizedTest
    fun name(name: String) {
        val person = introduce {
            name(name)
        }
        person.name shouldBe name
    }

    @Test
    fun company() {
        val person = introduce {
            name("홍길동")
            company("활빈당")
        }
        person.name shouldBe "홍길동"
        person.company shouldBe "활빈당"
    }

    @Test
    fun skills() {
        val person = introduce {
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
        }
        person.skills.size shouldBe 3
        person.skills[0].skillType shouldBe SkillType.SOFT
        person.skills[0].message shouldBe "A passion for problem solving"
        person.skills[1].skillType shouldBe SkillType.SOFT
        person.skills[1].message shouldBe "Good communication skills"
        person.skills[2].skillType shouldBe SkillType.HARD
        person.skills[2].message shouldBe "Kotlin"
    }

    @Test
    fun languages() {
        val person = introduce {
            languages {
                "Korean" level 5
                "English" level 3
            }
        }
        person.languages.size shouldBe 2
        person.languages[0].name shouldBe "Korean"
        person.languages[0].level shouldBe 5
        person.languages[1].name shouldBe "English"
        person.languages[1].level shouldBe 3
    }

    @Test
    fun `전체 테스트`() {
        val person = introduce {
            name("홍길동")
            company("활빈당")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
            languages {
                "Korean" level 5
                "English" level 3
            }
        }
        person.name shouldBe "홍길동"
        person.company shouldBe "활빈당"
        person.skills.size shouldBe 3
        person.skills[0].skillType shouldBe SkillType.SOFT
        person.skills[0].message shouldBe "A passion for problem solving"
        person.skills[1].skillType shouldBe SkillType.SOFT
        person.skills[1].message shouldBe "Good communication skills"
        person.skills[2].skillType shouldBe SkillType.HARD
        person.skills[2].message shouldBe "Kotlin"
        person.languages.size shouldBe 2
        person.languages[0].name shouldBe "Korean"
        person.languages[0].level shouldBe 5
        person.languages[1].name shouldBe "English"
        person.languages[1].level shouldBe 3
    }
}
