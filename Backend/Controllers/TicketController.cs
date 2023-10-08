using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Backend.Models;
using Backend.Services;

namespace Backend.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TicketController : ControllerBase
    {
        private readonly TicketServices _ticketServices;

        public TicketController(TicketServices ticketServices)
        {
            _ticketServices = ticketServices;
        }

        [HttpGet]
        public async Task<List<Ticket>> GetTicket()
            => await _ticketServices.GetAsync();

        [HttpPost]
        public async Task<Ticket> PostUser(Ticket ticket)
        {
            await _ticketServices.CreateAsync(ticket);

            return ticket;
        }

        [HttpGet("{id}")]
        public async Task<Ticket> GetTicket(string id)
            => await _ticketServices.GetAsync(id);

        [HttpPut("{id}")]
        public async Task<Ticket> PutTicket(string id, Ticket ticket)
        {
            await _ticketServices.UpdateAsync(id, ticket);

            return ticket;
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteTicket(string id)
        {
            await _ticketServices.RemoveAsync(id);

            return NoContent();
        }

    }
}
