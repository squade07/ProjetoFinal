using ProjetoFinalApi.Models;

namespace ProjetoFinalApi.Repository.Interfaces
{
    public interface IEscolaRepository
    {
        Task<List<EscolaModel>> BuscarTodasEscolas();
        Task<EscolaModel> BuscarPorId(int id);
        Task<EscolaModel> Adicionar(EscolaModel escola);
        Task<EscolaModel> Atualizar(EscolaModel escola, int id);
        Task<bool> Apagar(int id);
    }
}
