using ProjetoFinalApi.Models;

namespace ProjetoFinalApi.Repository.Interfaces
{
    public interface IDoadorRepository
    {
        Task<List<DoadorModel>> BuscarTodosDoadores();
        Task<DoadorModel> BuscarPorId(int id);
        Task<DoadorModel> Adicionar(DoadorModel doador);
        Task<DoadorModel> Atualizar(DoadorModel doador, int id);
        Task<bool> Apagar(int id);
    }
}
