using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProjetoFinalApi.Models;
using ProjetoFinalApi.Repository;
using ProjetoFinalApi.Repository.Interfaces;

namespace ProjetoFinalApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DoadorController : ControllerBase
    {
        private readonly IDoadorRepository _doadorRepository;
        public DoadorController(IDoadorRepository doadorRepository)
        {
            _doadorRepository = doadorRepository;
        }
        [HttpGet]
        public async Task< ActionResult<List<DoadorModel>>> BuscarTodosDoadores()
        {
           List<DoadorModel> doadores =  await _doadorRepository.BuscarTodosDoadores();
            return Ok(doadores);
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<List<DoadorModel>>> BuscarPorId(int id)
        {
            DoadorModel doador = await _doadorRepository.BuscarPorId(id);
            return Ok(doador);
        }
        [HttpPost]
        public async Task<ActionResult<DoadorModel>> Cadastrar([FromBody] DoadorModel doadorModel)
        {
            DoadorModel doador = await _doadorRepository.Adicionar(doadorModel);
            return Ok(doador); 
        }
        [HttpPut("{id}")]
        public async Task<ActionResult<DoadorModel>> Atualizar([FromBody] DoadorModel doadorModel, int id)
        {
            doadorModel.Id = id;
            DoadorModel doador = await _doadorRepository.Atualizar(DoadorModel, id);
            return Ok(doador);
        }
        [HttpDelete("{id}")]
        public async Task<ActionResult<DoadorModel>> Deletar(int id)
        {
           
            bool apagado  = await _doadorRepository.Apagar( id);
            return Ok(apagado);
        }
    }
}
