using System.ComponentModel;

namespace ProjetoFinalApi.Enuns
{
    public enum StatusEntrega
    {
        [Description("A Entregar !")]
        Aviajar = 1,
        [Description("Entregando !")]
        Viajando = 2,
        [Description("Entregou !")]
        Concluido =3,
    }
}
