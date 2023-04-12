// https://leetcode.com/problems/simplify-path/submissions/932511797/

function simplifyPath(path: string): string {
    const brokenPath = path.split('/').filter(p => p.length > 0);
    const finalPath: string[] = [];
    brokenPath.forEach((p, i) => {
        if (p === '..') {
            finalPath.pop();
        } else if (p !== '.') {
            finalPath.push(p);
        }
    });

    return `/${finalPath.join('/')}`;
};