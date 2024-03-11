Feature: Avancement

  Background:
    * call read('karate-config.js')
    * call read('db_cleaner.js')
    * url avancementUrl
    * header Content-Type = 'application/json'

    * def postBody = read('AvancementSave.json')
    * def FindAllSchema = read('AvancementSchema.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.ref = uuid()

  @duplicate
  Scenario Outline: POST Avancement Twice with same ref - expect <responseCode> as response code
    * postBody.code = uniqueId
    * def count = db.readValue('select count(*) FROM item.avancement')

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status <responseCode>
    * eval if(__num==1 && count != db.readValue('select count(*) FROM item.avancement')) karate.fail("avancement count values in DB are different")

    Examples:
      | responseCode |
      | 201          |
      | 226          |

  Scenario: Fail - GetByID Not Found

    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0



  Scenario: Fail - POST Avancement without Body

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"



  Scenario: Fail - POST Avancement without Authorization

    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 500



  Scenario: Fail - Save Avancement with method PATCH

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"
