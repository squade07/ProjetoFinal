using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProjetoFinalApi.Models;
using ProjetoFinalApi.Repository;
using ProjetoFinalApi.Repository.Interfaces;

namespace ProjetoFinalApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EscolaController : ControllerBase
    {
        private readonly IEscolaRepository _escolaRepository;
        public EscolaController(IEscolaRepository escolaRepository)
        {
            _escolaRepository = escolaRepository;
        }
        [HttpGet]
        public async Task< ActionResult<List<EscolaModel>>> BuscarTodasEscolas()
        {
           List<EscolaModel> escolas =  await _escolaRepository.BuscarTodasEscolas();
            return Ok(escolas);
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<List<EscolaModel>>> BuscarPorId(int id)
        {
            EscolaModel escola = await _escolaRepository.BuscarPorId(id);
            return Ok(escola);
        }
        [HttpPost]
        public async Task<ActionResult<EscolaModel>> Cadastrar([FromBody] EscolaModel escolaModel)
        {
            EscolaModel escola = await _escolaRepository.Adicionar(escolaModel);
            return Ok(escola); 
        }
        [HttpPut("{id}")]
        public async Task<ActionResult<EscolaModel>> Atualizar([FromBody] EscolaModel escolaModel, int id)
        {
            escolaModel.Id = id;
            EscolaModel escola = await _escolaRepository.Atualizar(escolaModel, id);
            return Ok(escola);
        }
        [HttpDelete("{id}")]
        public async Task<ActionResult<EscolaModel>> Deletar(int id)
        {
           
            bool apagado  = await _escolaRepository.Apagar( id);
            return Ok(apagado);
        }
    }
}
