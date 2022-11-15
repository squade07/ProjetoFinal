using ProjetoFinalApi.Enuns;

namespace ProjetoFinalApi.Models
{
    public class UsuarioModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Login { get; set; }
        public string Senha { get; set; }
        public StatusEntrega Status { get; set; }
    }
}
