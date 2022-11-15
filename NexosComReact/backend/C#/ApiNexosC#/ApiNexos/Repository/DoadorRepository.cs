using Microsoft.EntityFrameworkCore;
using ProjetoFinalApi.Data;
using ProjetoFinalApi.Models;
using ProjetoFinalApi.Repository.Interfaces;

namespace ProjetoFinalApi.Repository
{
    public class DoadorRepository : IDoadorRepository
    {
        private readonly SistemaEscolarDbContext _dbContext;
        public DoadorRepository(SistemaEscolarDbContext sistemaEscolarDbContext)
        {
            _dbContext = sistemaEscolarDbContext;
        }
        public async Task<DoadorModel> BuscarPorId(int id)
        {
            return await _dbContext.Doadores.FirstOrDefaultAsync(x => x.Id == id);
        }

        public async Task<List<DoadorModel>> BuscarTodosDoadores()
        {
            return await _dbContext.Doadores.ToListAsync();
        }
        public async Task<DoadorModel> Adicionar(DoadorModel doador)
        {
            await _dbContext.Doadores.AddAsync(doador);
            await _dbContext.SaveChangesAsync();
            return doador;
        }

        public async Task<bool> Apagar(int id)
        {
            DoadorModel doadorPorId = await BuscarPorId(id);
            if (doadorPorId == null)
            {
                throw new Exception($"Doador do ID:{id} não foi encontrado");
            }
            _dbContext.Doadores.Remove(doadorPorId);
            await _dbContext.SaveChangesAsync();
            return true;
        }

        public async Task<DoadorModel> Atualizar(DoadorModel doador, int id)
        {
            DoadorModel doadorPorId = await BuscarPorId(id);
            if (doadorPorId == null)
            {
                throw new Exception($"Doador do ID:{id} não foi encontrado");
            }
            doadorPorId.Nome = doador.Nome;
            doadorPorId.Cpf = doador.Cpf;
            doadorPorId.Produto = doador.Produto;
            doadorPorId.Telefone = doador.Telefone;
            doadorPorId.Quantidade= doador.Quantidade;

            _dbContext.Doadores.Update(doadorPorId);
            await _dbContext.SaveChangesAsync();
            return doadorPorId;
        }


    }
}
