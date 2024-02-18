Feature: Test Automation Rest API

  @api
  Scenario: Test get list user normal
    Given prepare url for "USER_DUMMY"
    And hit api get list users
    Then Validation status code is equal 200
    Then validation response body get list users
    Then Validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test get profile user normal
    Given prepare url for "GET_PROFILE_USER"
    When hit api get profile user by id "60d0fe4f5311236168a109cd"
    Then Validation status code is equal 200
    Then validation response body get profile users
    Then Validation response json with JSONSchema "get_profile_user_normal.json"

  @api
  Scenario:Test get data profile user failed not found
    Given prepare url for "GET_PROFILE_USER"
    When hit api get profile user by id "65bb2ac113492cde6cfbd2d8"
    Then Validation status code is equal 404
    Then validation response body with message "RESOURCE_NOT_FOUND"
    Then Validation response json with JSONSchema "get_profile_user_not_found.json"

  @api
  Scenario:Test create new user normal
    Given prepare url for "USER_DUMMY"
    When hit api post create new user
    Then Validation status code is equal 200
    Then validation response body post create new user
    Then Validation response json with JSONSchema "post_create_user_normal.json"

  @api
  Scenario: Test update user normal
    Given prepare url for "USER_DUMMY"
    And hit api post create new user
    Then Validation status code is equal 200
    Then validation response body post create new user
    And hit api update data
    Then Validation status code is equal 200
    Then validation response body update user

  @api
  Scenario:Test delete user normal
    Given prepare url for "USER_DUMMY"
    And hit api post create new user
    Then Validation status code is equal 200
    Then validation response body post create new user
    When hit api delete user
    Then Validation status code is equal 200

  @api
  Scenario:Test Delete user with user id not found
    Given prepare url for "USER_DUMMY"
    When hit delete user by id "65bb2ac113492cde6cfbd2d8"
    Then Validation status code is equal 404
    Then validation response body with message "RESOURCE_NOT_FOUND"

  @api
  Scenario:Test Get List Data Tag Normal
    Given prepare url for "GET_LIST_TAGS"
    When hit api get list tags
    Then Validation status code is equal 200
    Then validation response body get list tags