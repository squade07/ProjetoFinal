using Microsoft.EntityFrameworkCore;
using ProjetoFinalApi.Models;

namespace ProjetoFinalApi.Data.Map
{
    public class DoadorMap : IEntityTypeConfiguration<DoadorModel>
    {
        public void Configure(Microsoft.EntityFrameworkCore.Metadata.Builders.EntityTypeBuilder<DoadorModel> builder)
        {
            builder.HasKey(x => x.Id);
            builder.Property(x => x.Nome).IsRequired().HasMaxLength(255);
            builder.Property(x => x.Produto).IsRequired().HasMaxLength(150);
            builder.Property(x => x.Quantidade).IsRequired().HasMaxLength(150);
            builder.Property(x => x.Cpf).IsRequired().HasMaxLength(150);
            builder.Property(x => x.Telefone).IsRequired().HasMaxLength(150);
        }
    }
}
