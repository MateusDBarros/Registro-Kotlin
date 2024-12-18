import java.util.ArrayList
import java.util.Scanner

class Pessoa(var name: String, var age: Int, var role: String)
fun main() {

    // Criando uma arraylist de objetos
    val pessoas = ArrayList<Pessoa>();
    do {
        // Printa as opções a serem escolhidas
        println("1. Criar Novo Registro")
        println("2. Ver Registros.")
        println("3. Atualizar Registros")
        println("4. Deletar Registros")
        println("5. Sair")
        println("Escolha sua opção")

        // Cria um objeto do scanner e le o input do usuario
        val reader = Scanner(System.`in`)
        var userInput: Int = reader.nextInt()
        reader.nextLine()

        when (userInput) {
            // Cria novos Registros
            1 -> {
                print("Insira um nome para o registro: ")
                var name = reader.nextLine()
                print("Digite a idade de $name: ")
                var age = reader.nextInt()
                reader.nextLine()
                print("Digite a profissão de $name: ")
                var role = reader.nextLine()
                pessoas.add(Pessoa(name, age, role))
                println("Novo registro adicionado")
                println()
            }
            // Lista todos os Registros
            2 -> {
                if (!pessoas.isEmpty()) {
                    println("Lista de Registros:")
                    read(pessoas)
                    println()
                } else
                    println("Registros vazio")
            }
            // Atualiza um Registro
            3 -> {
                if (!pessoas.isEmpty()) {
                    print("Digite o nome do registro que deseja atualizar: ")
                    var update = reader.nextLine()
                    var index = check(pessoas, update)
                    if (index == -1)
                    {
                        println("Registro não encontrado")
                    }
                    else {
                        update(pessoas, index)
                        println("Registro atualizado com sucesso")
                        read(pessoas)
                        println()
                    }
                } else
                    println("Registros vazio")
            }
            // Delete um Registro
            4 -> {
                if (!pessoas.isEmpty()) {
                    print("Digite o nome do registro que deseja excluir: ")
                    var delete = reader.nextLine()
                    var index = check(pessoas, delete)
                    if (index == -1)
                    {
                        println("Registro não encontrado")
                    }
                    else {
                        delete(pessoas, index)
                        println("Registro deletado com sucesso")
                        read(pessoas)
                        println()
                    }
                } else
                    println("Registros vazio")
            }
            5 -> {
                println("\t---Software made by mateusDbarros\u00AE")
            }

            else -> {
                println("Ação invalida")
            }

        }
    } while (userInput != 5)

}
fun read(pessoas: ArrayList<Pessoa>) {
    for (pessoa in pessoas) {
        println("Nome: ${pessoa.name}, Idade: ${pessoa.age}, Profissão: ${pessoa.role}")
    }
}

fun check(pessoas: ArrayList<Pessoa>, name: String): Int {
    for (i in pessoas.indices) {
        if (name.equals(pessoas.get(i).name)) return i
    }
    return -1
}

fun update(pessoas: ArrayList<Pessoa>, index: Int) {
    val reader = Scanner(System.`in`)
    val newPessoa = pessoas.get(index)
    print("Deseja atualizar esse registro (y/n)?")
    var choice = reader.nextLine()
    if (choice.equals("y", ignoreCase = true)) {
        var continuar = true

            while (continuar) {
                print("O que deseja alterar? ('Nome', 'Idade', 'Profissao') ")
                var userInput = reader.nextLine()

                when (userInput) {
                    "Nome" -> {
                        print("Digite o novo nome: ")
                        var name = reader.nextLine()
                        newPessoa.name = name
                        println("Dado atualizado: ${newPessoa.name}")
                    }
                    "Idade" -> {
                        print("Digite a nova idade: ")
                        var age = reader.nextInt()
                        newPessoa.age = age
                        println("Dado atualizado: ${newPessoa.age}")
                    }
                    "Profissao" -> {
                        print("Digite a nova profissão: ")
                        var role = reader.nextLine()
                        newPessoa.role = role
                        println("Dado atualizado: ${newPessoa.role}")
                    }
                }
                println("Deseja editar mais alguma coisa? (y/n)")
                var userContinuar = reader.nextLine()
                if (userContinuar.equals("Y", ignoreCase = true))
                    continuar = true
                else continuar = false
            }
    }
    else
        println("Retornando...")
}

fun delete(pessoas: ArrayList<Pessoa>, index: Int) {
    val reader = Scanner(System.`in`)

    print("Deseja excluir esse registro (y/n)?")
    do {
        var choice = reader.nextLine()
        if (choice.equals("y", ignoreCase = true)) {
            pessoas.removeAt(index)
            return
    }
        else if (choice.equals('n'))
            println("Retornando...")
        else
            println("Escolha invalida")
    } while (!choice.equals('n'))

}

