//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Kakeru Nakabachi on 2021/01/02.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import shared

struct RocketLaunchRow: View {
    var rocketLaunch: RocketLaunch
    
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0, content: {
                Text("Launch name: \(rocketLaunch.missionName)")
                   Text(launchText).foregroundColor(launchColor)
                   Text("Launch year: \(String(rocketLaunch.launchYear))")
                   Text("Launch details: \(rocketLaunch.details ?? "")")
            })
            Spacer()
        }
    }
}

extension RocketLaunchRow {
    private var launchText: String {
        if let isScuccess = rocketLaunch.launchSuccess {
            return isScuccess.boolValue ? "Successful" : "Unsuccessful"
        } else {
            return "No data"
        }
    }
    
    private var launchColor: Color {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? Color.green : Color.red
        } else {
            return Color.gray
        }
    }
}
