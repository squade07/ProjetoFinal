using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProjetoFinalApi.Models;
using ProjetoFinalApi.Repository;
using ProjetoFinalApi.Repository.Interfaces;

namespace ProjetoFinalApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProdutoController : ControllerBase
    {
        private readonly IProdutoRepository _produtoRepository;
        public ProdutoController(IProdutoRepository produtoRepository)
        {
            _produtoRepository = produtoRepository;
        }
        [HttpGet]
        public async Task< ActionResult<List<ProdutoModel>>> BuscarTodosProdutos()
        {
           List<ProdutoModel> produtos =  await _produtoRepository.BuscarTodosProdutos();
            return Ok(produtos);
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<List<ProdutoModel>>> BuscarPorId(int id)
        {
            ProdutoModel produto = await _produtoRepository.BuscarPorId(id);
            return Ok(produto);
        }
        [HttpPost]
        public async Task<ActionResult<ProdutoModel>> Cadastrar([FromBody] ProdutoModel produtoModel)
        {
            ProdutoModel produto = await _produtoRepository.Adicionar(produtoModel);
            return Ok(produto); 
        }
        [HttpPut("{id}")]
        public async Task<ActionResult<ProdutoModel>> Atualizar([FromBody] ProdutoModel produtoModel, int id)
        {
            produtoModel.Id = id;
            ProdutoModel produto = await _produtoRepository.Atualizar(produtoModel, id);
            return Ok(produto);
        }
        [HttpDelete("{id}")]
        public async Task<ActionResult<ProdutoModel>> Deletar(int id)
        {
           
            bool apagado  = await _produtoRepository.Apagar( id);
            return Ok(apagado);
        }
    }
}
