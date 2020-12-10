/*
 *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.time.manager.cms.api.fallback;

import cn.hutool.system.UserInfo;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.api.dto.UserInfoDTO;
import com.time.manager.cms.api.feign.UserFeignClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wlj
 */
@Slf4j
@Component
public class UserFeignClientImpl implements UserFeignClient {
    @Setter
    private Throwable cause;

    @Override
    public R<UserInfoDTO> findByName(String userName) {
        return null;
    }
}
