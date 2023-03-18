fun main() {
    val userTransfer = totalTransfer(transfer = 75_000, userCard = "Visa", mounthLimit = 50_000)
    println("Сумма комиссии: $userTransfer")
}

fun totalTransfer(transfer: Int, userCard: String, mounthLimit: Int) = when (userCard) {
    "MasterCard", "Maestro" -> {
        when {
            mounthLimit < 600_000 -> {
                if (transfer < 75_000) {
                    0
                } else {
                    ((transfer * 0.006) + 20).toInt()
                }
            }

            else -> ("Внимание! Сумма месячных переводов по $userCard превышена")
        }
    }

    "Visa", "Mir" -> {
        when {
            mounthLimit < 600_000 -> {
                if (transfer * 0.075 < 35) {
                    35
                } else {
                    (transfer * 0.075).toInt()
                }
            }

            else -> ("Внимание! Сумма месячных переводов по $userCard превышена")
        }
    }

    "VK_pay" -> {
        when {
            mounthLimit < 40_000 -> 0

            else -> ("Внимание! Сумма месячных переводов по $userCard превышена")
        }
    }

    else -> ("Внимание! внесены не корректные данные")
}
