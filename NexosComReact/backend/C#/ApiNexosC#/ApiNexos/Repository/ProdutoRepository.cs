using Microsoft.EntityFrameworkCore;
using ProjetoFinalApi.Data;
using ProjetoFinalApi.Models;
using ProjetoFinalApi.Repository.Interfaces;

namespace ProjetoFinalApi.Repository
{
    public class ProdutoRepository : IProdutoRepository
    {
        private readonly SistemaEscolarDbContext _dbContext;
        public ProdutoRepository(SistemaEscolarDbContext sistemaEscolarDbContext)
        {
            _dbContext = sistemaEscolarDbContext;
        }
        public async Task<ProdutoModel> BuscarPorId(int id)
        {
            return await _dbContext.Produtos.FirstOrDefaultAsync(x => x.Id == id);
        }

        public async Task<List<ProdutoModel>> BuscarTodosProdutos()
        {
            return await _dbContext.Produtos.ToListAsync();
        }
        public async Task<ProdutoModel> Adicionar(ProdutoModel produto)
        {
            await _dbContext.Produtos.AddAsync(produto);
            await _dbContext.SaveChangesAsync();
            return produto;
        }

        public async Task<bool> Apagar(int id)
        {
            ProdutoModel produtoPorId = await BuscarPorId(id);
            if (produtoPorId == null)
            {
                throw new Exception($"Produto do ID:{id} não foi encontrado");
            }
            _dbContext.Produtos.Remove(produtoPorId);
            await _dbContext.SaveChangesAsync();
            return true;
        }

        public async Task<ProdutoModel> Atualizar(ProdutoModel produto, int id)
        {
            ProdutoModel produtoPorId = await BuscarPorId(id);
            if (produtoPorId == null)
            {
                throw new Exception($"Produto do ID:{id} não foi encontrado");
            }
            produtoPorId.Nome = produto.Nome;
            produtoPorId.Quantidade = produto.Quantidade;
            produtoPorId.Categoria = produto.Categoria;

            _dbContext.Produtos.Update(produtoPorId);
            await _dbContext.SaveChangesAsync();
            return produtoPorId;
        }


    }
}
