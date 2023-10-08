using Microsoft.Extensions.Options;
using MongoDB.Driver;
using Backend.Models;

namespace Backend.Services
{
    public class TicketServices
    {
        private readonly IMongoCollection<Ticket> _ticketCollection;

        public TicketServices(IOptions<EasyQueueDBSettings> ticketServices)
        {
            var mongoClient = new MongoClient(ticketServices.Value.ConnectionString);
            var mongoDatabase = mongoClient.GetDatabase(ticketServices.Value.DatabaseName);

            _ticketCollection = mongoDatabase.GetCollection<Ticket>
                (ticketServices.Value.TicketCollectionName);

        }

        public async Task<List<Ticket>> GetAsync() =>
            await _ticketCollection.Find(x => true).ToListAsync();
        public async Task<Ticket> GetAsync(string id) =>
           await _ticketCollection.Find(x => x.Id == id).FirstOrDefaultAsync();
        public async Task CreateAsync(Ticket ticket) =>
            await _ticketCollection.InsertOneAsync(ticket);
        public async Task UpdateAsync(string id, Ticket ticket) =>
           await _ticketCollection.ReplaceOneAsync(x => x.Id == id, ticket);
        public async Task RemoveAsync(string id) =>
            await _ticketCollection.DeleteOneAsync(x => x.Id == id);

    }
}
