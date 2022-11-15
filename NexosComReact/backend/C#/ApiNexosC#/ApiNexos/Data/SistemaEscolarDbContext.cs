using Microsoft.EntityFrameworkCore;
using ProjetoFinalApi.Data.Map;
using ProjetoFinalApi.Models;

namespace ProjetoFinalApi.Data
{
    public class SistemaEscolarDbContext : DbContext
    {
        public SistemaEscolarDbContext(DbContextOptions<SistemaEscolarDbContext> options)
            : base(options)
        {

        }
        public DbSet<UsuarioModel> Usuarios { get; set; }
        public DbSet<ProdutoModel> Produtos { get; set; }
        public DbSet<EscolaModel> Escolas { get; set; }
        public DbSet<DoadorModel> Doadores { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.ApplyConfiguration(new UsuarioMap());
            modelBuilder.ApplyConfiguration(new ProdutoMap());
            modelBuilder.ApplyConfiguration(new EscolaMap());
            modelBuilder.ApplyConfiguration(new DoadorMap());

            base.OnModelCreating(modelBuilder);
        }
    }
}
