using Microsoft.EntityFrameworkCore;
using ProjetoFinalApi.Data;
using ProjetoFinalApi.Models;
using ProjetoFinalApi.Repository.Interfaces;

namespace ProjetoFinalApi.Repository
{
    public class EscolaRepository : IEscolaRepository
    {
        private readonly SistemaEscolarDbContext _dbContext;
        public EscolaRepository(SistemaEscolarDbContext sistemaEscolarDbContext)
        {
            _dbContext = sistemaEscolarDbContext;
        }
        public async Task<EscolaModel> BuscarPorId(int id)
        {
            return await _dbContext.Escolas.FirstOrDefaultAsync(x => x.Id == id);
        }

        public async Task<List<EscolaModel>> BuscarTodasEscolas()
        {
            return await _dbContext.Escolas.ToListAsync();
        }
        public async Task<EscolaModel> Adicionar(EscolaModel escola)
        {
            await _dbContext.Escolas.AddAsync(escola);
            await _dbContext.SaveChangesAsync();
            return escola;
        }

        public async Task<bool> Apagar(int id)
        {
            EscolaModel escolaPorId = await BuscarPorId(id);
            if (escolaPorId == null)
            {
                throw new Exception($"Escola do ID:{id} não foi encontrado");
            }
            _dbContext.Escolas.Remove(escolaPorId);
            await _dbContext.SaveChangesAsync();
            return true;
        }

        public async Task<EscolaModel> Atualizar(EscolaModel escola, int id)
        {
            EscolaModel escolaPorId = await BuscarPorId(id);
            if (escolaPorId == null)
            {
                throw new Exception($"Escola do ID:{id} não foi encontrado");
            }
            escolaPorId.Nome = escola.Nome;
            escolaPorId.Opinioes = escola.Opinioes;
            escolaPorId.Telefone = escola.Telefone;
            escolaPorId.Cnpj = escola.Cnpj;
            escolaPorId.Produto = escola.Produto;
            escolaPorId.Quantidade = escola.Quantidade;


            _dbContext.Escolas.Update(escolaPorId);
            await _dbContext.SaveChangesAsync();
            return escolaPorId;
        }


    }
}
