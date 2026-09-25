import XCTest
@testable import PrivacyScreenPlugin

class PrivacyScreenTests: XCTestCase {

    // The template's echo test referred to an API this plugin never had, so the target did not compile.
    func testMethodTable() {
        let plugin = PrivacyScreenPlugin()

        XCTAssertEqual(plugin.jsName, "PrivacyScreen")
        XCTAssertEqual(plugin.pluginMethods.map(\.name), ["enable", "disable"])
        XCTAssertTrue(plugin.pluginMethods.allSatisfy { $0.returnType == .promise })
    }

    func testConfigDefaults() {
        let config = PrivacyScreenConfig()

        XCTAssertTrue(config.enable)
        XCTAssertEqual("", config.imageName)
        XCTAssertEqual("center", config.contentMode)
        XCTAssertEqual(true, config.preventScreenshots)
    }
}
