Pod::Spec.new do |spec|
    spec.name                     = 'DroidconKit'
    spec.version                  = '1.1'
    spec.homepage                 = 'https://github.com/touchlab/DroidconKotlin'
    spec.source                   = { :git => "Not Published", :tag => "Cocoapods/#{spec.name}/#{spec.version}" }
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Common library for the Droidcon app'

    spec.static_framework         = true
    spec.vendored_frameworks      = "build/cocoapods/framework/DroidconKit.framework"
    spec.libraries                = "c++"
    spec.module_name              = "#{spec.name}_umbrella"





    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':ios',
        'PRODUCT_MODULE_NAME' => 'DroidconKit',
    }

    spec.script_phases = [
        {
            :name => 'Build ios',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$COCOAPODS_SKIP_KOTLIN_BUILD" ]; then
                  echo "Skipping Gradle build task invocation due to COCOAPODS_SKIP_KOTLIN_BUILD environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration=$CONFIGURATION \
                    -Pkotlin.native.cocoapods.cflags="$OTHER_CFLAGS" \
                    -Pkotlin.native.cocoapods.paths.headers="$HEADER_SEARCH_PATHS" \
                    -Pkotlin.native.cocoapods.paths.frameworks="$FRAMEWORK_SEARCH_PATHS"
            SCRIPT
        }
    ]
end