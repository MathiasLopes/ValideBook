Feature: Features of my DAO Implementations

Background:
    Given my book dao class exists

Scenario: Get book by id
    Given Get book by id
    When get book with id 1
    Then book should by only one or null

Scenario: Get book list 
    Given Get book list 
    When get all books
    Then books should be list of size zero or plus

