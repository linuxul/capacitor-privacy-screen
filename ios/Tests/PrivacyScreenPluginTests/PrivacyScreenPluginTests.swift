import XCTest
@testable import PrivacyScreenPlugin

class PrivacyScreenTests: XCTestCase {

    // The template's echo test referred to an API this plugin never had, so the target did not compile.
    func testConfigDefaults() {
        let config = PrivacyScreenConfig()

        XCTAssertTrue(config.enable)
        XCTAssertEqual("", config.imageName)
        XCTAssertEqual("center", config.contentMode)
        XCTAssertEqual(true, config.preventScreenshots)
    }
}
