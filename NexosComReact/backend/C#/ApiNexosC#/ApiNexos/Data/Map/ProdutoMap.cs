using Microsoft.EntityFrameworkCore;
using ProjetoFinalApi.Models;

namespace ProjetoFinalApi.Data.Map
{
    public class ProdutoMap : IEntityTypeConfiguration<ProdutoModel>
    {
        public void Configure(Microsoft.EntityFrameworkCore.Metadata.Builders.EntityTypeBuilder<ProdutoModel> builder)
        {
            builder.HasKey(x => x.Id);
            builder.Property(x => x.Nome).IsRequired().HasMaxLength(255);
            builder.Property(x => x.Categoria).IsRequired().HasMaxLength(150);
            builder.Property(x => x.Quantidade).IsRequired().HasMaxLength(150);
        }
    }
}
