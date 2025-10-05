# Announcement List API

## Overview
This document describes the custom response structure created for the announcement list endpoint based on the provided JSON structure.

## API Endpoint
```
GET /announcements
```

### Request Object (AnnouncementRequest)
The endpoint now uses an `AnnouncementRequest` object with validation instead of individual query parameters:

#### Fields:
- `title` (optional, max 100 chars): Filter by announcement title
- `description` (optional, max 500 chars): Filter by announcement description
- `status` (optional): Filter by announcement status (active, pending, etc.)
- `type` (optional): Filter by land type (agricole, constructible, etc.)
- `announcementTransaction` (optional): Filter by announcement transaction type
- `startDate` (optional): Filter by start date
- `endDate` (optional): Filter by end date
- `page` (optional, default: 0, min: 0): Page number for pagination
- `size` (optional, default: 10, min: 1): Number of items per page

#### Validation Rules:
- Title: Maximum 100 characters
- Description: Maximum 500 characters
- Page: Must be >= 0
- Size: Must be >= 1

### Response Structure
```json
{
  "announcements": [
    {
      "id": 1,
      "title": "Terrain agricole avec vue panoramique",
      "location": "Chambéry, Savoie",
      "price": 85000.0,
      "surface": 50000.0,
      "type": "agricole",
      "status": "active",
      "views": 0,
      "favorites": 0,
      "messages": 0,
      "image": "/placeholder.svg?height=200&width=300",
      "createdAt": "2024-01-15",
      "description": "Magnifique terrain agricole avec vue imprenable sur les montagnes",
      "features": ["Terrain certifié", "Usage agricole", "Grande superficie"],
      "lastActivity": "Il y a quelques heures"
    }
  ],
  "totalCount": 2,
  "currentPage": 0,
  "totalPages": 1,
  "hasNext": false,
  "hasPrevious": false
}
```

## Key Components Created

### 1. AnnouncementSummaryDTO
Located at: `core/src/main/java/com/samasouf/dto/AnnouncementSummaryDTO.java`

This DTO represents individual announcement items in the list response, matching the JSON structure provided.

### 2. AnnouncementListResponse
Located at: `core/src/main/java/com/samasouf/dto/AnnouncementListResponse.java`

This is the main response wrapper that includes:
- List of announcement summaries
- Pagination metadata (totalCount, currentPage, totalPages, hasNext, hasPrevious)

### 3. MapStruct Mapper Interface
- `AnnouncementMapperInterface`: Single MapStruct interface with `@Mapper(componentModel = "spring")`:
  - Entity to DTO conversion (Announcement → AnnouncementDTO)
  - DTO to Summary conversion (AnnouncementDTO → AnnouncementSummaryDTO)
  - Automatic field mapping with `@Mappings` annotations
  - Custom helper methods for complex mappings (location, features, images)
  - Generated Spring component for dependency injection
  - No default values set in mappings (as requested)

### 4. JPA Repository and Specifications
- `AnnouncementRepository`: JPA repository with specification support
- `AnnouncementSpecification`: Dynamic query builder using JPA Criteria API:
  - Title and description filtering (case-insensitive)
  - Status and type filtering
  - Date range filtering
  - Location-based filtering
  - Pagination and sorting support

### 5. Command Pattern Implementation
- `IAnnouncementListCommand`: Interface for basic announcement listing
- `AnnouncementListCommandImpl`: JPA-based implementation using specifications
- `IAnnouncementListResponseCommand`: Interface for the response command
- `AnnouncementListResponseCommandImpl`: Implementation that orchestrates data retrieval and mapping

### 6. Controller Integration
- `AnnouncementController`: Dedicated controller with validation
- Uses `AnnouncementRequest` object with validation annotations
- `RequestMapper`: Converts request objects to criteria objects

## Usage Examples

### Using Query Parameters (GET request)
```bash
# Get all announcements with default pagination
curl "http://localhost:8080/announcements"

# Get announcements with filters
curl "http://localhost:8080/announcements?status=active&type=agricole&page=0&size=5"

# Get announcements with title filter
curl "http://localhost:8080/announcements?title=terrain&page=0&size=10"
```

### Validation Error Response
When validation fails, the API returns a structured error response:
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Error",
  "message": "Validation failed",
  "errors": [
    "Title must not exceed 100 characters",
    "Page number must be greater than or equal to 0"
  ],
  "path": "/announcements"
}
```

## Notes
- **Production Ready**: The implementation uses JPA specifications for database queries (no mock data)
- **MapStruct Integration**: Uses MapStruct with Spring component model for automatic mapping generation
- **Clean Mapping**: No default values set in mapper - all values come from actual data or are ignored
- **Dynamic Filtering**: JPA specifications allow for complex, dynamic queries based on criteria
- **Pagination**: Full pagination support with sorting by creation date (most recent first)
- **Validation**: Request validation with meaningful error messages
- Views, favorites, messages, and lastActivity fields are ignored in mappings and should be populated by separate services
- Features are automatically generated based on land properties using helper methods

## Database Requirements
Ensure your database has the following tables with proper relationships:
- `announcement` table with foreign keys to `app_user` and `land`
- `land` table with foreign key to `location`
- `media` table with foreign key to `land`
- Proper JPA entity relationships configured

## MapStruct Code Generation
The mapper implementation is automatically generated at compile time:
- Run `mvn compile` to generate the mapper implementation
- Generated class: `AnnouncementMapperInterfaceImpl` (Spring component)
- MapStruct processor is configured in the parent pom.xml
- Works seamlessly with Lombok annotations
