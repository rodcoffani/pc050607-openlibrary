# PC 05-07

## Status
Finalizado.

## Comportamento
- Busca informações de livros na OpenLibraryAPI.
- A busca só acontece quando o livro não é encontrado no cache.
- A pesquisa no cache é feita com base no título (se estiver com título errado = não encontra)
- Salve apenas o primeiro resultado da pesquisa na OpenLibraryAPI, não a consulta toda.