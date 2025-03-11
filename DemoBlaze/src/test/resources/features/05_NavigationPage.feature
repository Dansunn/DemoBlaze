Feature: Verify Pagination on Product Listing

  @Navigation @Next
Scenario: Navigate between product pages
  Given User is on the first page
  When User clicks the next page button
  Then The next set of products should be displayed

  @Navigation @Previous
Scenario: Navigate back to the previous page
  Given User is on the second page of products
  When User clicks the previous page button
  Then The first set of products should be displayed
