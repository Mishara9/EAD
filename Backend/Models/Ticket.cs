using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace Backend.Models
{
    public class Ticket
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string? TId { get; set; }

        [BsonElement("UName")]
        public string UName { get; set; } = null;

        [BsonElement("UserIdentity")]
        public string UIdentity { get; set; } = null;

        [BsonElement("Train")]
        public string Train { get; set; } = null;

        [BsonElement("Platform")]
        public string Platform { get; set; } = null;

        [BsonElement("Price")]
        public string Price { get; set; } = null;

        [BsonElement("Date")]
        public string Date { get; set; } = null;

        [BsonElement("Time")]
        public string Time { get; set; } = null;
    }
}
